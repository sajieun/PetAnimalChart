package kr.pet.chart.controller;

import kr.pet.chart.model.PetClient;

import java.util.ArrayList;
import java.util.List;

public class PetClientController {
    private List<PetClient> petClients;
    private MedicalRecoredContorller recoredContorller;

    public PetClientController(MedicalRecoredContorller recoredContorller){
        this.petClients=new ArrayList<>();
        this.recoredContorller=recoredContorller;
    }

//    고객정보를 등록하는 메서드
    public void addClient(PetClient petClient){
        petClients.add(petClient);
    }

//    고객정보를 삭제하는 메서드
    public void removeClient(String phone){
        for (int i=0;i< petClients.size();i++){
            if (petClients.get(i).getPhone().equals(phone)){
                petClients.remove(i);
                recoredContorller.removeMedicalRecord(phone); // 해당 고객의 진료 기록도 삭제
                break;
            }
        }
    }
//    고객정보를 검색하는 기능
    public PetClient findPetClient(String phone){
        for (PetClient petClient : petClients){
            if (petClient.getPhone().equals(phone)){
                return petClient;
            }
        }
        return null;
    }

//    기존의 전화번호로 등록된 고객이 있는지를 확인하는 메서드
    public boolean isPhoneExist(String phone) {
        for (PetClient petClient : petClients) {
            if (petClient.getPhone().equals(phone)) {
                return true; // 중복
            }
        }
        return false; // 중복x
    }
}

