package Thanh_Phan;


import java.util.Scanner;


public class ThongTin implements Comparable<ThongTin>{
    private String ID;
    private String Dia_Chi;
    private String SDT;
    private String Email;

    public ThongTin(){

    }
    public ThongTin(String ID, String Dia_Chi, String SDT, String Email){
        this.ID = ID;
        this.Dia_Chi = Dia_Chi;
        this.SDT = SDT;
        this.Email = Email;
    }
    Scanner sc = new Scanner(System.in);
    public String getID() {
        return ID;
    }

    public String getDia_Chi() {
        return Dia_Chi;
    }

    public String getSDT() {
        return SDT;
    }

    public String getEmail() {
        return Email;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public void setDia_Chi(String dia_Chi) {
        Dia_Chi = dia_Chi;
    }

    public void setSDT(String SDT) {
        this.SDT = SDT;
    }

    public void setEmail(String email) {
        Email = email;
    }
    public void nhap(){
        System.out.print("Mời Nhập ID: ");
        this.ID = sc.nextLine();
        System.out.print("Mời Nhập Địa Chỉ: ");
        this.Dia_Chi = sc.nextLine();
        System.out.print("Mời Nhập Số Điện Thoại: ");
        this.SDT = sc.nextLine();
        System.out.print("Mời Nhập Email: ");
        this.Email = sc.nextLine();
    }
    //    public String toString() {
//        return String.format("%35s|%10s|%8.1f|%8.1f|%8.1f|" +  ho_ten, diachi, ngaysinh, diemtoan, ly, hoa);
//    }

    @Override
    public String toString() {
        return String.format("%-10s|%-20s|%-10s|%-35s" , this.getID(), this.getDia_Chi(), this.getSDT(), this.getEmail());
    }


//    public String toString()
//    {
//        return String.format("%-10s|%-20s|%-10s|%35s|" + this.getID(), this.getDia_Chi(), this.getSDT(), this.getEmail());
////        return String.format("%-10s|%-20s|%-10s|%35s|" + this.getID(), this.getDia_Chi(), this.getSDT(), this.getEmail());
////        return this.getID() + " | " + this.getDia_Chi() + " | " + this.getSDT() + " | " + this.getEmail();
//    }

    @Override
    public int compareTo(ThongTin o) {
        int k = this.getID().compareTo(o.getID());
        if( k < 0){
            return -1;
        }else if(k > 0){
            return 1;
        }else {
            return 0;
        }
    }
}
