package QuanLy;

import DOCGIFLE.DocGhiFile;
import Thanh_Phan.Sach;
import java.util.Collections;
import java.awt.*;
import java.util.ArrayList;
import java.util.Scanner;

public class QuanLyKhoSach {
    private Scanner scanner = new Scanner(System.in);
    private ArrayList<Sach> dss;
    private DocGhiFile docghi;
    private int key;

    public QuanLyKhoSach(){
        dss = new ArrayList<Sach>();
        docghi = new DocGhiFile();
    }
    public  void menuSach()
    {
//        docghi.GhiFileSach("sach.txt",dss);
        do {
            System.out.println("*********************** Quản lý Sách ***********************");
            System.out.println("***               1. Thêm sách                           ***");
            System.out.println("***               2. Sửa sách                            ***");
            System.out.println("***               3. Xóa sách                            ***");
            System.out.println("***               4. Tìm kiếm sách                       ***");
            System.out.println("***               5. Sắp xếp sách                        ***");
            System.out.println("***               6. Đọc file sách                       ***");
            System.out.println("***               0. Quay Lại                            ***");
            System.out.print("***               Chọn chức năng : ");
            key = scanner.nextInt();

            switch (key) {
                case 1:
                    themsach();
                    break;
                case 2:
                    suasach();
                    break;
                case 3:
                    xoasach();
                    break;
                case 4:
                    timsach();
                    break;
                case 5:
                    sapxepsach();
                    break;
                case 6:
                    show();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Khong co chuc nang nay! Vui lòng chọn chức năng khác: ");
            }
        } while (key != 0);

    }


    public void themsach()
    {
        boolean check = false;
        scanner.nextLine();
        System.out.println("*********************** Thêm sách ***********************");
        System.out.print("Nhập số sách cần thêm : ");
        int n = scanner.nextInt();
        for (int i = 1 ; i <= n; i++)
        {
            Sach s = new Sach();
            check = false;
            System.out.println("Nhập sách thứ " + (dss.size()+1) + " : ");
            s.nhap();
            for (Sach sach : dss)
            {//Phương pháp trả về 0 nếu chuỗi bằng với chuỗi khác, bỏ qua sự khác biệt trường hợp.
                // Một giá trị nhỏ hơn 0 sẽ được trả về nếu chuỗi nhỏ hơn chuỗi khác (ít ký tự hơn)
                // và giá trị lớn hơn 0 nếu chuỗi lớn hơn chuỗi khác (nhiều ký tự hơn).
                if (sach.getID_Sach().equalsIgnoreCase(s.getID_Sach()))
                {
                    check = true;
                    break;
                }
            }
            if (check)
            {
                System.out.println("Mã sách bị trùng");
            }
            else
            {
                dss.add(s);
                System.out.println("Thêm sách thành công");
            }
        }
        docghi.GhiFileSach("sach.txt",dss);
    }

    public void suasach()
    {
        boolean check = false;
        boolean check1 = false;
        System.out.println("*********************** Sửa sách ***********************");

        if (dss.size() == 0)
        {
            System.out.println("**Danh sách rỗng chưa có sách nào ở trong này hãy thêm sách để thực hiện chức năng!**");
        }
        else
        {
            scanner.nextLine();
            System.out.print("Nhập ID sách cần sửa : ");
            String id = scanner.nextLine();
            for (Sach s : dss)
            {
                if (s.getID_Sach().equalsIgnoreCase(id))
                {
                    check = true;
                    Sach s1 = new Sach();
                    s1.nhap();
                    for (Sach sach : dss)
                    {
                        if (sach.getID_Sach().compareToIgnoreCase(id) != 0 && s1.getID_Sach().compareToIgnoreCase(sach.getID_Sach()) == 0)
                        {
                            System.out.println("ID sách bị trùng");
                            check1 = true;
                            break;
                        }
                    }
                    //nếu check 1 # thì là vẫn trả về false
                    if (!check1)
                    {
                        s.setID_Sach(s1.getID_Sach());
                        s.setTen_Sach(s1.getTen_Sach());
                        s.setDon_Gia(s1.getDon_Gia());
                        s.setSo_Luong(s1.getSo_Luong());
                        s.setNXB(s1.getNXB());
                        s.setThe_Loai(s1.getThe_Loai());
                        s.setTinh_Trang(s1.getTinh_Trang());
                        s.setNCC(s1.getNCC());
                        s.setThanh_Tien(s1.getSo_Luong() * s1.getDon_Gia());
                        s.setNam_Nhap(s1.getNam_Nhap());
                        docghi.GhiFileSach("sach.txt", dss);
                        System.out.println("Sửa sách thành công!");
                    }
                }
            }
            if (!check)
            {
                System.out.println("Không tồn tại ID sách này!");
            }
        }
    }

    public void xoasach() {
        boolean check = false;
        int vitri = 0;// để gán vị trí mà sách nhập vào  để xóa
        scanner.nextLine();
        System.out.println("*********************** Xóa sách ***********************");
        if (dss.size() == 0)
        {
            System.out.println("Danh sách rỗng hãy nhập thêm sách để thực hiện chức năng!");
        }
        else
        {
            System.out.print("Nhập ID sách cần xóa: ");
            String id = scanner.nextLine();
            for (int i = 0; i < dss.size(); i++)
            {
                Sach s = dss.get(i);
                if (s.getID_Sach().equalsIgnoreCase(id)) {
                    vitri = i;
                    check = true;
                    break;
                }
            }
            if (check)
            {
                dss.remove(vitri);
                docghi.GhiFileSach("sach.txt", dss);
                System.out.println("Xóa thành công!");
            }
            else
            {
                System.out.println("Không tồn tại ID sách này!");
            }
        }
    }

    public void timsach()
    {
        String timkiem;
        boolean check = false;
        scanner.nextLine();
        System.out.println("*********************** Tìm kiếm sách ***********************");
        if (dss.size() == 0)
        {
            System.out.println("Danh sách rỗng hãy nhập thêm sách để thực hiện chức năng!");
        }
        else
        {
            System.out.print("Nhập ID sách hoặc tên cuốn sách cần tìm: ");
            timkiem = scanner.nextLine();
            for (Sach s : dss)
            {
                if (s.getID_Sach().equalsIgnoreCase(timkiem) || s.getTen_Sach().equalsIgnoreCase(timkiem) ) {
                    check = true;
                    System.out.print(s);
                }
            }
            if (!check)
            {
                System.out.println("Không tìm thấy ID sách đã nhập!");
            }
        }
    }

    public void sapxepsach()
    {
        Collections.sort(dss);
        docghi.GhiFileSach("sach.txt", dss);
        System.out.println("Sắp xếp thành công!");
    }

    public void show()
    {
        System.out.println("*********************** Đọc file Sách ***********************");
        if (dss.size() == 0)
        {
            System.out.println("Danh sách rỗng hãy nhập thêm sách để thực hiện chức năng!");
        }else {
            System.out.printf("%-5s|%-10s|%-10s|%-7s|%-10s|%-5s|%-3s|%-10s|%-8s|%-4s\n","Mã Sách","Tên Sách","Đơn Giá","Số Lượng ","Nhà Xuất Bản","Thể Loại","Tình Trạng","Nhà Cung Cấp", "Thành Tiền", "Năm Nhập");
            docghi.docFile("sach.txt");
        }
    }
}

