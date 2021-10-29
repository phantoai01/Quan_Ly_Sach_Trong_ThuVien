package QuanLy;


import DOCGIFLE.DocGhiFile;
import Thanh_Phan.ThuThu;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;


public class QuanLyThuThu {

    private Scanner sc = new Scanner(System.in);
    private ArrayList<ThuThu> dstt;
    private DocGhiFile docghi;
    private int key;

    public QuanLyThuThu() {
        dstt = new ArrayList<ThuThu>();
        docghi = new DocGhiFile();
    }

    public void menuThuThu() {
//        docghi.GhiFileThuThu("thuthu.txt", dstt);
        do {
            System.out.println("*********************** Quản lý Thủ thư ***********************");
            System.out.println("***               1. Thêm thủ thư                           ***");
            System.out.println("***               2. Sửa thủ thư                            ***");
            System.out.println("***               3. Xóa thủ thư                            ***");
            System.out.println("***               4. Tìm kiếm thủ thư                       ***");
            System.out.println("***               5. Sắp xếp thủ thư                        ***");
            System.out.println("***               6. Đọc file thủ thư                       ***");
            System.out.println("***               0. Quay Lại                               ***");
            System.out.print("***               Chọn chức năng : ");
            key = sc.nextInt();

            switch (key) {
                case 1:
                    themthuthu();
                    break;
                case 2:
                    suathuthu();
                    break;
                case 3:
                    xoathuthu();
                    break;
                case 4:
                    timthuthu();
                    break;
                case 5:
                    sapxepthuthu();
                    break;
                case 6:
                    display();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Khong co chuc nang nay! vui lòng chọn chức năng: ");
            }
        } while (key != 0);

    }

    void themthuthu() {
        boolean check = false;
        sc.nextLine();
        System.out.println("*********************** Thêm thủ thư ***********************");
        System.out.print("Nhập số thủ thư cần thêm : ");
        int n = sc.nextInt();
        for (int i = 1; i <= n; i++)
        {
            ThuThu tt = new ThuThu();
            check = false;
            System.out.println("Nhập thủ thư thứ " + (dstt.size() + 1) + " : ");
            tt.nhap();
            for (ThuThu thuthu : dstt) {
                //equalsIgnoreCase không phân biệt hoa thường
                if (thuthu.getID().equalsIgnoreCase(tt.getID())) {
                    check = true;
                    break;
                }
            }
            if (check) {
                System.out.println("Mã thủ thư bị trùng");
            } else {
                dstt.add(tt);
                System.out.println("Thêm thủ thư thành công");
            }
        }
        docghi.GhiFileThuThu("thuthu.txt", dstt);
    }

    void suathuthu() {
        boolean check = false;
        sc.nextLine();
        System.out.println("*********************** Sửa thủ thư ***********************");
        if (dstt.size() == 0) {
            System.out.println("Danh sách thủ thư đang rỗng hãy nhập thêm thủ thư để thực hiện chức năng này!");
        } else {
            System.out.print("Nhập ID thủ thư cần sửa : ");
            String id = sc.nextLine();
            for (ThuThu tt : dstt) {
                if (tt.getID().equalsIgnoreCase(id)) {
                    check = true;
                    boolean check1 = false;
                    ThuThu tt1 = new ThuThu();
                    tt1.nhap();
                    for (ThuThu thuthu : dstt) {
                        // lấy id từng vị trí # còn lại trong mảng đi so sánh id đã nhập vào khác nhau và cái cuốn sách vừa thêm so vs id sách có trong mảng nếu trùng thì trả về giống nhau = 0
                        if (thuthu.getID().compareToIgnoreCase(id) != 0 && tt1.getID().compareToIgnoreCase(thuthu.getID()) == 0) {
                            System.out.println("ID thủ thư bị trùng!");
                            check1 = true;
                            break;
                        }
                    }
                    if (!check1) {
                        tt.setID(tt1.getID());
                        tt.setHo_Ten(tt1.getHo_Ten());
                        tt.setNamSinh(tt1.getNamSinh());
                        tt.setDia_Chi(tt1.getDia_Chi());
                        tt.setSDT(tt1.getSDT());
                        tt.setEmail(tt1.getEmail());
                        docghi.GhiFileThuThu("thuthu.txt", dstt);
                        System.out.println("Sửa thử thư thành công!");
                    }
                }
            }
            if (!check) {
                System.out.println("Không tồn tại thủ thư nào với ID này!");
            }
        }

    }

    void xoathuthu() {
        boolean check = false;
        int vitri = 0;
        sc.nextLine();
        System.out.println("*********************** Xóa thủ thư ***********************");
        if (dstt.size() == 0) {
            System.out.println("Danh sách thủ thư hiện tại đang rỗng hãy nhập thêm để thực hiện chức năng này!");
        } else {
            System.out.print("Nhập ID thủ thư cần xóa: ");
            String id = sc.nextLine();
            for (int i = 0; i < dstt.size(); i++) {
                ThuThu tt = dstt.get(i);
                if (tt.getID().equalsIgnoreCase(id)) {
                    vitri = i;
                    check = true;
                    break;
                }
            }
            if (check) {
                dstt.remove(vitri);
                docghi.GhiFileThuThu("thuthu.txt", dstt);
                System.out.println("Xóa thành công!");
            } else {
                System.out.println("Không tồn tại mã thủ thư!");
            }
        }

    }

    void timthuthu() {
        String timkiem;
        boolean check = false;
        sc.nextLine();
        System.out.println("*********************** Tìm kiếm thủ thư ***********************");
        if (dstt.size() == 0) {
            System.out.println("Danh sách trống hãy nhập thêm để thực hiện chức năng!");
        } else {
            System.out.print("Nhập ID thủ thư hoặc tên thủ thư cần tìm: ");
            timkiem = sc.nextLine();
            for (ThuThu thuthu : dstt) {
                if (thuthu.getID().equalsIgnoreCase(timkiem)  || thuthu.getHo_Ten().equalsIgnoreCase(timkiem) ) {
                    check = true;
                    System.out.print(thuthu);
                }
            }
            if (!check) {
                System.out.println("Không tìm thấy!");
            }
        }
    }

    void sapxepthuthu() {
        Collections.sort(dstt);
        docghi.GhiFileThuThu("thuthu.txt", dstt);
        System.out.println("Sắp xếp thành công!");
    }

    void display() {
        System.out.println("*********************** Đọc file nhà cung cấp ***********************");
        if (dstt.size() == 0) {
            System.out.println("Danh sách trống hãy nhập thêm để thực hiện chức năng!");
        } else {
        System.out.printf("%-20s|%-8s|%-10s|%-20s|%-10s|%-35s|\n", "Họ Và Tên","Năm Sinh", "Mã TT", "Địa Chỉ", "SĐT", "Email");
        docghi.docFile("thuthu.txt");
        }
    }
}