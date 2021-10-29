package QuanLyHeThong;

import QuanLy.QuanLyKhoSach;
import QuanLy.QuanLyNhaCungCap;
import QuanLy.QuanLyThuThu;

import java.util.Scanner;

public class USER {
    public void quyenuser(){
        Scanner sc = new Scanner(System.in);
        QuanLyKhoSach quanLyKhoSach = new QuanLyKhoSach();
        QuanLyNhaCungCap quanLyNhaCungCap = new QuanLyNhaCungCap();
        int key;

        do
        {
            System.out.println("************************** Quyền User **************************");
            System.out.println("***               1. Quản lý Kho Sách                        ***");
            System.out.println("***               2. Quản lý Nhà Cung Cấp                    ***");
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
