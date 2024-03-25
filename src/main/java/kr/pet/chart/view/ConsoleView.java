package kr.pet.chart.view;

import kr.pet.chart.model.MedicalRecord;
import kr.pet.chart.model.PetClient;

import java.util.List;
import java.util.Scanner;

public class ConsoleView {
    private Scanner scanner = new Scanner(System.in);

//    전화번호 입력받는 화면
    public String getphone(){
        System.out.print("전화번호를 입력하세요: ");
        return scanner.nextLine();
    }

//    신규 정보 입력받는 화면
    public PetClient getClientInfo(){
        System.out.println("신규 고객 정보를 입력하세요.");

        System.out.print("전화번호:");
        String phone = scanner.nextLine();

        System.out.print("소유주 이름:");
        String ornername = scanner.nextLine();

        System.out.print("동물 이름:");
        String petname = scanner.nextLine();

        System.out.print("주소:");
        String address = scanner.nextLine();

        System.out.print("종류:");
        String petkind = scanner.nextLine();

        System.out.print("출생년도(YYYY):");
        String birth = scanner.nextLine();
        scanner.nextLine(); // Client the newline character left by nextInt()
        return new PetClient(phone,ornername,petname,address,petkind,birth);
    }

//    진료 입력 받는 화면
    public MedicalRecord getMedicalRecordInfo(){

        System.out.print("진료일을 입력하세요: ");
        String date = scanner.nextLine();

        System.out.print("진료내용을 입력하세요: ");
        String content = scanner.nextLine();

        return new MedicalRecord(null,date,content);
    }

//    진료 기록을 조회하여 출력하는 화면
    public void printMedicalRecordInfo(PetClient petClient){
        List<MedicalRecord> records = petClient.getMedicalRecords();
        System.out.println("["+petClient.getPetname()+"]의 진료기록");
        for (MedicalRecord record : records){
            System.out.println("-진료일: "+record.getDate());
            System.out.println("-진료내용: "+record.getContent());
            System.out.println("-소유주 이름: "+petClient.getOrnername());
            System.out.println("-동물 이름: "+petClient.getPetname());
            System.out.println("-주소: "+petClient.getAddress());
            System.out.println("-종류: "+petClient.getPetkind());
            System.out.println("-출생년도: "+petClient.getBirth());
        }
    }

    public void printMessage(String message){
        System.out.println(message);
    }

}
