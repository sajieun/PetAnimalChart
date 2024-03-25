package kr.pet.chart.controller;

import kr.pet.chart.model.MedicalRecord;

import java.util.ArrayList;
import java.util.List;

public class MedicalRecoredContorller {
    private List<MedicalRecord>  records = new ArrayList<>();

    // 진료기록을 등록하는 메서드
    public void addMedicalRecord(MedicalRecord record){
        records.add(record);
    }

//    진료기록을 삭제하는 메서드
    public void removeMedicalRecord(String phone){
        for (int i=0;i<records.size();i++){
            if (records.get(i).getPhone().equals(phone)){
                records.remove(i);
                break;
            }
        }
    }

//    전화번호에 해당하는 모든 진료기록을 검색하여 새로운 List<MedicalRecord>를 만들어주는 메서드
    public List<MedicalRecord> findMedicalRecords(String phone){
        List<MedicalRecord> result = new ArrayList<>();
        for (MedicalRecord record : records){
            if (record.getPhone().equals(phone)){
                result.add(record);
            }
        }
        return result;
    }
}
