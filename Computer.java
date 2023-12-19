package Assignment;

import java.util.Objects;

//----------------------------------------------
// Assignment (One)
// © Your Name
// Written by: (include your name and student id)
//------------------------------------------------

    public class Computer {

        //Defining properties for a computer
        private String brand;
        private String model;
        private long serialNumber;
        private long serialNumberCounter = 1000000;
        private double price;
        private int numberOfCreatedComputer = 0;

        //Getters for properties of class
        public String getBrand() {
            return brand;
        }

        public String getModel() {
            return model;
        }

        public long getSerialNumber() {
            return serialNumber;
        }

        public double getPrice() {
            return price;
        }

        //Setters for properties of class

        public void setBrand(String brand) {
            this.brand = brand;
        }

        public void setModel(String model) {
            this.model = model;
        }

        public void setPrice(double price) {
            this.price = price;
        }



        //Constructors for the class

        public Computer(){
        }
        public Computer(String brand, String model, double price) {
            this.brand = brand;
            this.model = model;
            this.price = price;
            serialNumberCounter++;
            numberOfCreatedComputer++;
            serialNumber = serialNumberCounter;

        }

        public int numberOfCreatedComputer(){
            return numberOfCreatedComputer;
        }

        public String toString() {
            return "Computer # " + numberOfCreatedComputer + "\n"+
                    "Brand: " + brand + "\n" +
                    "ComputerModel: " + model + "\n" +
                    "SN: "+serialNumber + "\n" +
                    ", ComputerPrice $" + price
                    ;
        }


        public boolean equal(Computer computer) {
            if(brand == computer.brand && price == computer.price && model == computer.model ){
                return true;
            }else
                return false;
        }




    }
