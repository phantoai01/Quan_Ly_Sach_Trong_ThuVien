package QuanLyHeThong;

import QuanLy.QuanLyKhoSach;
import QuanLy.QuanLyNhaCungCap;
import QuanLy.QuanLyThuThu;
import QuanLy.ThongKe;

import java.util.Scanner;

public class Admin {

    public void quyenadmin(){

        Scanner sc = new Scanner(System.in);
        QuanLyKhoSach quanLyKhoSach = new QuanLyKhoSach();
        QuanLyNhaCungCap quanLyNhaCungCap = new QuanLyNhaCungCap();
        QuanLyThuThu quanLyThuThu = new QuanLyThuThu();
        ThongKe thongke = new ThongKe();
        int  key;
        do
        {
            System.out.println("************************* Quyền Admin **************************");
            System.out.println("***               1. Quản lý Kho Sách                        ***");
            System.out.println("***               2. Quản lý Nhà Cung Cấp                    ***");
            System.out.println("***               3. Quản lý Thủ Thư                         ***");
            System.out.println("***               4. Thống Kê Sách                           ***");
            System.out.println("***               0. Quay Lại                                ***");
            System.out.print("***               Chọn chức năng : ");
            key = sc.nextInt();
            switch (key)
            {
                case 1:
                    quanLyKhoSach.menuSach();
                    break;
                case 2:
                    quanLyNhaCungCap.menuNhacungcap();
                    break;
                case 3:
                    quanLyThuThu.menuThuThu();
                    break;
                case 4:
                    thongke.menuThongKe();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Vui lòng chọn chức năng: ");
                    break;
            }
        }
        while(key != 0);
    }
}
