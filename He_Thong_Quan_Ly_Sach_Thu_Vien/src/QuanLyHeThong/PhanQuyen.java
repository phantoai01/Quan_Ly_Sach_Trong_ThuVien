package QuanLyHeThong;
//Nhóm 1 chủ đề 8
/*họ Và Tên Các thành Viên trong Nhóm gồm:
1. Phan Hữu Toại - 71DCHT22129- 71DCHT21
2. Vương Việt Anh
3. Nguyễn Đình Huy
4. Nguyễn Thị Thùy Linh*/

import java.util.Scanner;

public class PhanQuyen {
    public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    Admin admin = new Admin();
    USER user = new USER();
    int key;

        do
        {
            System.out.println("************************** Quản Lý Thư Viện **************************");
            System.out.println("***                  1. Quyền Quản Lý Của Admin                    ***");
            System.out.println("***                  2. Quyền Quản Lý Của User                     ***");
            System.out.println("***                  0. Thoát                                      ***");
            System.out.print("***                  Chọn chức năng : ");
            key = scanner.nextInt();
            switch (key)
            {
                case 1:
                    admin.quyenadmin();
                    break;
                case 2:
                    user.quyenuser();
                    break;
                case 0:
                    System.out.println("Kết thúc!");
                    break;
                default:
                    System.out.println("Vui lòng chọn chức năng: ");
                    break;
            }
        }
        while(key != 0);
    }


}
