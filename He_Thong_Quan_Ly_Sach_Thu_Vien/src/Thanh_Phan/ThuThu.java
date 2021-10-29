package Thanh_Phan;

public class ThuThu extends ThongTin{
    private String Ho_Ten;
    private int NamSinh;

    public ThuThu(){

    }
    public ThuThu(String Ho_Ten, int NamSinh, String ID, String Dia_Chi, String SDT, String Email){
        super(ID, Dia_Chi, SDT, Email);
        this.Ho_Ten = Ho_Ten;
        this.NamSinh = NamSinh;
    }

    public String getHo_Ten() {
        return Ho_Ten;
    }

    public int getNamSinh() {
        return NamSinh;
    }

    public void setHo_Ten(String ho_Ten) {
        Ho_Ten = ho_Ten;
    }

    public void setNamSinh(int namSinh) {
        NamSinh = namSinh;
    }

    @Override
    public void nhap() {
        System.out.print("Mời Nhập Họ Và Tên: ");
        this.Ho_Ten = sc.nextLine();
        System.out.print("Mời Nhập Năm Sinh: ");
        this.NamSinh = Integer.parseInt(sc.nextLine());
        super.nhap();
    }

    public String toString()
    {
        return String.format("%-20s|%-8s|%-75s|\n" , this.getHo_Ten(),this.getNamSinh(), super.toString());
//        return this.getHo_Ten() + " | " + this.getNamSinh() + " | " + super.toString() + "\n" ;
    }


}