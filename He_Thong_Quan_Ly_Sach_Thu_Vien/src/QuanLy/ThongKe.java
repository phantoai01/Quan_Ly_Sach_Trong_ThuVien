package QuanLy;

import DOCGIFLE.DocGhiFile;
import Thanh_Phan.Sach;

import javax.print.Doc;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

/*
Chức năng GV yêu cầu tối thiểu hoặc nhóm đề xuất (GV duyệt):
        Thư viện A quản lý danh sách các loại sách. Thông tin về các loại sách:
        Thủ Thư: mã thủ thư, họ tên, ngày sinh, địa chỉ, sdt, email
        Sách: Mã sách, đơn giá, số lượng, nhà xuất bản,thể loại, tình trạng (mới, cũ), nhà cung cấp, thành tiền.
        Nhà cung cấp: Mã Nhà cung cấp, tên nhà cung cấp, dịa chỉ, sdt, email.
        Xác định các tác nhân (Actor) và chức năng (Usecase)
        tác nhân: Thủ Thư
        chức năng:
        Quản lý kho Sách : Thêm, Sửa, Xóa, Tìm Kiếm.
        Quản lý Thủ Thư: Thêm, Sửa, Xóa, Tìm Kiếm.
        Quản lý nhà cung cấp: Thêm, Sửa, Xóa.
        Thông kê:
        + số lượng Sách nhập vào trong năm.
        + Thành tiền cho từng loại sách. (SGK,SBT, STK)
        + Thành tiền cho tổng Sách trong năm
        Quản lý hệ thống: phân quyền(thêm, sửa, xóa) :
        + admin: (quản lý kho sách, quản lý thủ thư, quản lý nhà cung cấp, quản lý hệ thống)
        + user: (quản lý khó sách, quản lý nhà cung cấp)
        Cơ sở dữ liệu tối thiểu dùng File, giao diện tối thiểu dùng console cho phép lựa chọn thực hiện các chức năng theo menu
*/
public class ThongKe {
    private Scanner scanner = new Scanner(System.in);
    private static ArrayList<Sach> dss;
    private int key;

    public ThongKe(){
        dss = new ArrayList<Sach>();
    }


    public  void menuThongKe()
    {
        do {
            System.out.println("*********************** Thống Kê Sách ***********************");
            System.out.println("***               1. số lượng Sách nhập vào trong năm.   ***");
            System.out.println("***               2. Thành tiền cho từng loại sách.      ***");
            System.out.println("***               3. Thành tiền cho tổng Sách trong năm  ***");
            System.out.println("***               0. Quay Lại                            ***");
            System.out.print("***               Chọn chức năng : ");
            key = scanner.nextInt();
            switch (key) {
                case 1:
                    SoSach();
                    break;
                case 2:
                    ThanhTien();
                    break;
                case 3:
                    tongtienSachTrongNam();
                case 0:
                    break;
                default:
                    System.out.println("Không có chức năng này! Vui lòng chọn chức năng khác: ");
            }
        } while (key != 0);
    }

    public void SoSach(){
        System.out.print("Nhập vào năm muốn thống kê số lượng sách: ");
        int namnhap = scanner.nextInt();
        boolean check = false;
        int sum = 0;
        DocFileThongKe("sach.txt", dss);
        for (int i = 0; i < dss.size(); i++) {
            if(dss.get(i).getNam_Nhap() == namnhap){
                sum += dss.get(i).getSo_Luong();
                check = true;
            }
        }
        if(!check){
            System.out.println("Năm này không nhập vào sách nào cả");
        }
        System.out.println("Số Sách được nhập vào trong năm " + namnhap + " là: " + sum);
    }

    public void ThanhTien(){
        DocFileThongKe("sach.txt", dss);
        double sumcu = 0;
        double summoi = 0;
        for (int i = 0; i < dss.size(); i++) {
            if(dss.get(i).getTinh_Trang().equalsIgnoreCase("cu")){
                sumcu += dss.get(i).getDon_Gia() * dss.get(i).getSo_Luong();
            }else if(dss.get(i).getTinh_Trang().equalsIgnoreCase("moi")){
                summoi += dss.get(i).getDon_Gia() * dss.get(i).getSo_Luong();
            }
        }
        System.out.println("Số tiền sau khi thống kê của thể loại sách Cũ là: "  + sumcu);
        System.out.println("Số tiền sau khi thống kê của thể loại sách Mới là: "  + summoi);
    }
    public void tongtienSachTrongNam(){
        System.out.print("Nhập vào năm muốn thống kê số tiền sách: ");
        int namnhap = scanner.nextInt();
        boolean check = false;
        double sum = 0;
        DocFileThongKe("sach.txt", dss);
        for (int i = 0; i < dss.size(); i++) {
            if(dss.get(i).getNam_Nhap() == namnhap){
                sum += dss.get(i).getDon_Gia() * dss.get(i).getSo_Luong();
                check = true;
            }
        }
        if(!check){
            System.out.println("Năm này không nhập vào sách nào cả");
        }
        System.out.println("Thành Tiền của tổng Sách trong năm " + namnhap + " là: " + sum);
    }

    public void DocFileThongKe(String filename, ArrayList<Sach> dss)
    {
        try {
            File file = new File(filename);
            if (file.exists())
            {
                FileInputStream fileInputStream = new FileInputStream(file);
                InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                String doc = bufferedReader.readLine();
                while (doc != null){
                    String[] a = doc.split("\\|");
                    Sach sach = new Sach(a[0], a[1], Double.parseDouble(a[2]), Double.parseDouble(a[3]), a[4], a[5], a[6], a[7], Double.parseDouble(a[8]), Double.parseDouble(a[9]));
                    dss.add(sach);
                    doc = bufferedReader.readLine();
                }
            }
            else
            {
                System.out.println("Không tồn tại file để đọc");
            }

        } catch (Exception e) {
            System.out.println("Lỗi: " + e.getMessage());
        }

    }

}
