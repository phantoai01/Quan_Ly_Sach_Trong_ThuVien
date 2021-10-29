package Thanh_Phan;

public class NhaCungCap extends ThongTin {
    private String tennhacungcap;

    public NhaCungCap(){

    }
    public NhaCungCap(String tennhacungcap, String ID, String Dia_Chi, String SDT, String Email){
        super(ID, Dia_Chi, SDT, Email);
        this.tennhacungcap = tennhacungcap;
    }

    public String getTennhacungcap() {
        return tennhacungcap;
    }

    public void setTennhacungcap(String tennhacungcap) {
        this.tennhacungcap = tennhacungcap;
    }

    @Override
    public void nhap() {
        System.out.print("Mời Nhập Tên Nhà Cung Cấp: ");
        this.tennhacungcap = sc.nextLine();
        super.nhap();
    }
    public String toString()
    {
        return String.format("%-20s|%-75s|\n" , this.getTennhacungcap(), super.toString());
//        return this.getTennhacungcap() + " | " + super.toString() + "\n";
    }

}
