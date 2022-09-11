package com.example.biomedtech.modelsDTO;

public class Account {

        public Account(String UUID, String fullname, String surname, String given, String prefix, String suffix, int idGender, String birthDate, int idNationality) {
                this.UUID = UUID;
                Fullname = fullname;
                Surname = surname;
                Given = given;
                Prefix = prefix;
                Suffix = suffix;
                IdGender = idGender;
                BirthDate = birthDate;
                IdNationality = idNationality;
        }

        public String getUUID() {
                return UUID;
        }

        public void setUUID(String UUID) {
                this.UUID = UUID;
        }

        public String getFullname() {
                return Fullname;
        }

        public void setFullname(String fullname) {
                Fullname = fullname;
        }

        public String getSurname() {
                return Surname;
        }

        public void setSurname(String surname) {
                Surname = surname;
        }

        public String getGiven() {
                return Given;
        }

        public void setGiven(String given) {
                Given = given;
        }

        public String getPrefix() {
                return Prefix;
        }

        public void setPrefix(String prefix) {
                Prefix = prefix;
        }

        public String getSuffix() {
                return Suffix;
        }

        public void setSuffix(String suffix) {
                Suffix = suffix;
        }

        public int getIdGender() {
                return IdGender;
        }

        public void setIdGender(int idGender) {
                IdGender = idGender;
        }

        public String getBirthDate() {
                return BirthDate;
        }

        public void setBirthDate(String birthDate) {
                BirthDate = birthDate;
        }

        public int getIdNationality() {
                return IdNationality;
        }

        public void setIdNationality(int idNationality) {
                IdNationality = idNationality;
        }


        private String UUID;
        private String Fullname;
        private String Surname;
        private String Given;
        private String Prefix;
        private String Suffix;
        private int IdGender;
        private String BirthDate;
        private int IdNationality;

        public int getId() {
                return Id;
        }

        public void setId(int id) {
                Id = id;
        }

        public String getGender() {
                return Gender;
        }

        public void setGender(String gender) {
                Gender = gender;
        }

        private String Gender;
        private int Id;
}
