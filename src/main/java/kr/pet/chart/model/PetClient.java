package kr.pet.chart.model;

import java.util.ArrayList;
import java.util.List;

public class PetClient {
    private String phone;
    private String ornername;
    private String petname;
    private String address;
    private String petkind;
    private String birth;
    private List<MedicalRecord> medicalRecords; // 진료 기록을 저장하는 리스트

    public PetClient() {} // 안 쓰더라도 생성자 만들기

    public PetClient(String phone, String ornername, String petname, String address, String petkind, String birth) {
        this.phone = phone;
        this.ornername = ornername;
        this.petname = petname;
        this.address = address;
        this.petkind = petkind;
        this.birth = birth;
        this.medicalRecords = new ArrayList<>(); // 일단 빈 list로 초기화
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getOrnername() {
        return ornername;
    }

    public void setOrnername(String ornername) {
        this.ornername = ornername;
    }

    public String getPetname() {
        return petname;
    }

    public void setPetname(String petname) {
        this.petname = petname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPetkind() {
        return petkind;
    }

    public void setPetkind(String petkind) {
        this.petkind = petkind;
    }

    public String getBirth() {
        return birth;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }

    public List<MedicalRecord> getMedicalRecords() {
        return medicalRecords;
    }

//    고객별로 진료기록을 등록
    public void addMedicalRecords(MedicalRecord records) { // getter만 이렇게 변경해주기
        medicalRecords.add(records);
    }
}