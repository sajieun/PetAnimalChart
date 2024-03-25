package kr.pet.chart;

import kr.pet.chart.controller.MedicalRecoredContorller;
import kr.pet.chart.controller.PetClientController;
import kr.pet.chart.model.MedicalRecord;
import kr.pet.chart.model.PetClient;
import kr.pet.chart.view.ConsoleView;

import java.util.List;
import java.util.Scanner;

public class PetMain {
    public static void main(String[] args) {
        MedicalRecoredContorller recoredContorller = new MedicalRecoredContorller();
        PetClientController petClientController = new PetClientController(recoredContorller);
        ConsoleView view = new ConsoleView();

        while (true){
            System.out.println("===애완동물진료관리시스템===");
            System.out.println("1. 신규 고객 정보 입력");
            System.out.println("2. 진료 기록 저장");
            System.out.println("3. 진료 기록 조회");
            System.out.println("4. 진료 기록 삭제");
            System.out.println("5. 종료");
            System.out.print("원하는 기능을 선택하세요: ");

            Scanner scanner = new Scanner(System.in);
            int choice = scanner.nextInt();
            switch (choice){
                case 1:
                    PetClient newPetclient = view.getClientInfo();
                    String phone = newPetclient.getPhone();
                    if (petClientController.isPhoneExist(phone)){
                        view.printMessage("이미 등록된 전화번호 입니다.");
                        continue;
                    }
                    petClientController.addClient(newPetclient);
                    view.printMessage("고객 정보가 추가되었습니다.");
                    break;
                case 2:
                    phone = view.getphone();
                    if (petClientController.findPetClient(phone) == null){
                        view.printMessage("해당 전화번호를 가진 고객 정보가 없습니다.");
                        break;
                    }
                    PetClient petClient = petClientController.findPetClient(phone);
                    MedicalRecord newRecord = view.getMedicalRecordInfo();
                    newRecord.setPhone(phone);
                    recoredContorller.addMedicalRecord(newRecord);
                    petClient.addMedicalRecords(newRecord);
                    view.printMessage("진료기록이 저장되었습니다.");
                    break;

                case 3:
                    phone = view.getphone();
                    List<MedicalRecord> records = recoredContorller.findMedicalRecords(phone);
                    if (records.isEmpty()){
                        view.printMessage("해당 전화번호를 가진 진료 기록이 없습니다.");
                        break;
                    }
                    petClient = petClientController.findPetClient(phone);
                    view.printMedicalRecordInfo(petClient);
                    break;

                case  4:
                    phone = view.getphone();
                    if (petClientController.findPetClient(phone) == null){
                        view.printMessage("해당 번호를 가진 고객 정보가 없습니다.");
                        break;
                    }
                    recoredContorller.removeMedicalRecord(phone);
                    view.printMessage("진료기록 정보가 삭제되었습니다.");
                    break;

                case 5:
                    view.printMessage("프로그램을 종료합니다.");
                    return;
                default:
                    view.printMessage("잘못된 선택입니다.");
                    break;
            }
        }
    }
}
