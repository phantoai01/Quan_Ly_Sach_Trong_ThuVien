package Thanh_Phan;

import java.util.Scanner;

//implement comparable để sắp xếp bắt buộc override lại hàm comparaTo sắp xếp
//implement 1 cái đối tượng
public class Sach implements Comparable<Sach>  {
    private String ID_Sach;
    private String Ten_Sach;
    private double Don_Gia;
    private double So_Luong;
    private String NXB;
    private String The_Loai;
    private String Tinh_Trang;
    private String NCC;
    private double Thanh_Tien;
    private double Nam_Nhap;

    public Sach(){

    }

    Scanner sc = new Scanner(System.in);

    public Sach(String ID_Sach, String Ten_Sach, double Don_Gia, double So_Luong, String NXB, String The_Loai, String Tinh_Trang, String NCC, double Thanh_Tien, double Nam_Nhap){
        this.ID_Sach = ID_Sach;
        this.Ten_Sach = Ten_Sach;
        this.Don_Gia = Don_Gia;
        this.So_Luong = So_Luong;
        this.NXB = NXB;
        this.The_Loai = The_Loai;
        this.Tinh_Trang = Tinh_Trang;
        this.NCC = NCC;
        this.Thanh_Tien = Thanh_Tien;
        this.Nam_Nhap = Nam_Nhap;
    }
//phím tắt tạo hàm tạo tự động alt + insert
    public void setID_Sach(String ID_Sach) {
        this.ID_Sach = ID_Sach;
    }

    public void setTen_Sach(String ten_Sach) {
        Ten_Sach = ten_Sach;
    }

    public void setDon_Gia(double don_Gia) {
        Don_Gia = don_Gia;
    }

    public void setSo_Luong(double so_Luong) {
        So_Luong = so_Luong;
    }

    public void setNXB(String NXB) {
        this.NXB = NXB;
    }

    public void setThe_Loai(String the_Loai) {
        The_Loai = the_Loai;
    }

    public void setTinh_Trang(String tinh_Trang) {
        Tinh_Trang = tinh_Trang;
    }

    public void setNCC(String NCC) {
        this.NCC = NCC;
    }

    public void setThanh_Tien(double thanh_Tien) {
        Thanh_Tien = thanh_Tien;
    }

    public void setNam_Nhap(double nam_Nhap) {
        Nam_Nhap = nam_Nhap;
    }

    public String getID_Sach() {
        return ID_Sach;
    }

    public String getTen_Sach() {
        return Ten_Sach;
    }

    public double getDon_Gia() {
        return Don_Gia;
    }

    public double getSo_Luong() {
        return So_Luong;
    }

    public String getNXB() {
        return NXB;
    }

    public String getThe_Loai() {
        return The_Loai;
    }

    public String getTinh_Trang() {
        return Tinh_Trang;
    }

    public String getNCC() {
        return NCC;
    }

    public double getThanh_Tien() {
        return Thanh_Tien;
    }

    public double getNam_Nhap() {
        return Nam_Nhap;
    }

    public void nhap(){
        System.out.print("Mời Nhập Vào Mã Sách: ");
        this.ID_Sach = sc.nextLine();
        System.out.print("Mời Nhập Vào Tên Sách: ");
        this.Ten_Sach = sc.nextLine();
        System.out.print("Mời Nhập Vào Đơn Giá: ");
        this.Don_Gia = Double.parseDouble(sc.nextLine());
        System.out.print("Mời Nhập Vào Số Lượng Sách: ");
        this.So_Luong = Double.parseDouble(sc.nextLine());
        System.out.print("Mời Nhập Vào Tên Nhà Xuất Bản: ");
        this.NXB = sc.nextLine();
        System.out.print("Mời Nhập Vào Thể Loại Sách: ");
        this.The_Loai = sc.nextLine();
        System.out.print("Mời Nhập Vào Tình trạng Sách: ");
        this.Tinh_Trang = sc.nextLine();
        System.out.print("Mời Nhập Vào Tên Nhà Cung Cấp: ");
        this.NCC = sc.nextLine();
        setThanh_Tien(thanhtien());
        System.out.print("Mời Nhập Vào Năm Nhập Sách: ");
        this.Nam_Nhap = sc.nextDouble();
    }

    public double thanhtien(){
        double thanhtien = So_Luong * Don_Gia;
        return thanhtien;
    }
    public String toString()
    {
        return this.getID_Sach() + " | "+ this.getTen_Sach() + " | "  + this.getDon_Gia() + " | " + this.getSo_Luong() + " | " + this.getNXB() + " | " + this.getThe_Loai() + " |" + this.getTinh_Trang() + "| " + this.getNCC() + " |" + this.getThanh_Tien() + "| " + this.getNam_Nhap() + "|" + "\n";
    }
    //compare đối tượng this hiện tại với 1 đói tượng sách truyền vào
    //nếu phần tử hiện tại nhỏ hơn cái phần tử so sánh thì trả về 1 để cho phần tử so sánh xuống dưới
    //nếu muốn phần tử so sánh lên đầu thì trả về -1
    //sắp xếp list các đối tượng
/*    Một giá trị: 0 nếu chuỗi bằng với chuỗi khác, bỏ qua sự khác biệt trường hợp.
    < 0 nếu chuỗi ít hơn về mặt từ
    điển khác > 0 nếu chuỗi lớn hơn về mặt từ điển so với chuỗi khác (nhiều ký tự hơn)*/
/*    Giá trị int: 0 nếu chuỗi này bằng chuỗi kia.
    <0 nếu chuỗi có từ vựng nhỏ hơn chuỗi khác> 0 nếu chuỗi có từ vựng lớn hơn chuỗi khác (nhiều ký tự hơn)*/
    // compareto so sánh chuỗi có phân biệt chữ thường và chữ hoa còn compareToIgnoreCase thì kh phân biệt hoa thường
    public int compareTo(Sach s) {
        int k = this.getID_Sach().compareTo(s.getID_Sach());
        if(k < 0){
            return -1; // sắp xếp tăng dần
        }else if( k > 0){
            return 1; // sắp xếp giảm dần
        }else {
            return 0; // bằng nhau
        }
    }
}
