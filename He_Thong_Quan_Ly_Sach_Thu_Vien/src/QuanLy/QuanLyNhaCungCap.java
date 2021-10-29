package QuanLy;

import DOCGIFLE.DocGhiFile;
import Thanh_Phan.NhaCungCap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class QuanLyNhaCungCap {
    private Scanner scanner = new Scanner(System.in);
    private ArrayList<NhaCungCap> dsncc;
    private DocGhiFile docghi;
    private int key;

    public QuanLyNhaCungCap(){
        dsncc = new ArrayList<NhaCungCap>();
        docghi = new DocGhiFile();
    }
    public  void menuNhacungcap()
    {
//        docghi.GhiFileNhaCungCap("nhacungcap.txt",dsncc);
        do {
            System.out.println("*********************** Quản lý Nhà Cung Cấp ***********************");
            System.out.println("***               1. Thêm nhà cung cấp                           ***");
            System.out.println("***               2. Sửa nhà cung cấp                            ***");
            System.out.println("***               3. Xóa nhà cung cấp                            ***");
            System.out.println("***               4. Tìm kiếm nhà cung cấp                       ***");
            System.out.println("***               5. Sắp xếp nhà cung cấp                        ***");
            System.out.println("***               6. Đọc file nhà cung cấp                       ***");
            System.out.println("***               0. Quay Lại                                    ***");
            System.out.print("***               Chọn chức năng : ");
            key = scanner.nextInt();

            switch (key) {
                case 1:
                    themnhachungcap();
                    break;
                case 2:
                    suanhachungcap();
                    break;
                case 3:
                    xoanhachungcap();
                    break;
                case 4:
                    timnhachungcap();
                    break;
                case 5:
                    sapxepnhachungcap();
                    break;
                case 6:
                    display();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Khong co chuc nang nay! Vui lòng chọn chức năng khác: ");
            }
        } while (key != 0);

    }

    void themnhachungcap()
    {
        boolean check = false;
        scanner.nextLine();
        System.out.println("*********************** Thêm nhà cung cấp ***********************");
        System.out.print("Nhập số nhà cung cấp cần thêm : ");
        int n = scanner.nextInt();
        for (int i = 1 ; i <= n; i++)
        {
            NhaCungCap ncc = new NhaCungCap();
            check = false;
            System.out.println("Nhập nhà cung cấp thứ " + (dsncc.size()+1) + " : ");
            ncc.nhap();
            for (NhaCungCap nhaCungCap : dsncc)
            {//Phương pháp trả về 0 nếu chuỗi bằng với chuỗi khác, bỏ qua sự khác biệt trường hợp.
                // Một giá trị nhỏ hơn 0 sẽ được trả về nếu chuỗi nhỏ hơn chuỗi khác (ít ký tự hơn)
                // và giá trị lớn hơn 0 nếu chuỗi lớn hơn chuỗi khác (nhiều ký tự hơn).
                if (nhaCungCap.getID().compareToIgnoreCase(ncc.getID()) == 0)
                {
                    check = true;
                    break;
                }
            }
            if (check)
            {
                System.out.println("ID nhà cung cấp bị trùng");
            }
            else
            {
                dsncc.add(ncc);
                System.out.println("Thêm nhà cung cấp thành công");
            }
        }
        docghi.GhiFileNhaCungCap("nhacungcap.txt",dsncc);
    }

    void suanhachungcap()
    {
        boolean check = false;
        boolean check1 = false;
        System.out.println("*********************** Sửa nhà cung cấp ***********************");

        if (dsncc.size() == 0)
        {
            System.out.println("**Danh sách rỗng chưa có nhà cung cấp nào ở trong này hãy thêm nhà cung để thực hiện chức năng!**");
        }
        else
        {
            scanner.nextLine();
            System.out.print("Nhập ID nhà cung cấp cần sửa : ");
            String id = scanner.nextLine();
            for (NhaCungCap ncc : dsncc)
            {
                if (ncc.getID().compareToIgnoreCase(id) == 0)
                {
                    check = true;
                    NhaCungCap ncc1 = new NhaCungCap();
                    ncc1.nhap();
                    for (NhaCungCap nhaCungCap : dsncc)
                    {
                        if (nhaCungCap.getID().compareToIgnoreCase(id) != 0 && ncc1.getID().compareToIgnoreCase(nhaCungCap.getID()) == 0)
                        {
                            System.out.println("ID sách bị trùng");
                            check1 = true;
                            break;
                        }
                    }
                    //nếu check 1 # thì là vẫn trả về false
                    if (!check1)
                    {
                        ncc.setID(ncc1.getID());
                        ncc.setTennhacungcap(ncc1.getTennhacungcap());
                        ncc.setDia_Chi(ncc1.getDia_Chi());
                        ncc.setEmail(ncc1.getEmail());
                        ncc.setSDT(ncc1.getSDT());
                        docghi.GhiFileNhaCungCap("nhacungcap.txt", dsncc);
                        System.out.println("Sửa nhà cung cấp thành công!");
                    }
                }
            }
            if (!check)
            {
                System.out.println("Không tồn tại ID nhà cung cấp này!");
            }
        }
    }

    void xoanhachungcap() {
        boolean check = false;
        int vitri = 0;// để gán vị trí mà nhà cung cấp nhập vào  để xóa
        scanner.nextLine();
        System.out.println("*********************** Xóa nhà cung cấp ***********************");
        if (dsncc.size() == 0)
        {
            System.out.println("Danh sách rỗng hãy nhập thêm nhà cung cấp để thực hiện chức năng!");
        }
        else
        {
            System.out.print("Nhập ID nhà cung cấp cần xóa: ");
            String id = scanner.nextLine();
            for (int i = 0; i < dsncc.size(); i++)
            {
                NhaCungCap ncc = dsncc.get(i);
                if (ncc.getID().compareToIgnoreCase(id) == 0) {
                    vitri = i;
                    check = true;
                    break;
                }
            }
            if (check)
            {
                dsncc.remove(vitri);
                docghi.GhiFileNhaCungCap("nhacungcap.txt", dsncc);
                System.out.println("Xóa thành công!");
            }
            else
            {
                System.out.println("Không tồn tại ID nhà cung cấp này!");
            }
        }
    }

    void timnhachungcap()
    {
        String timkiem;
        boolean check = false;
        scanner.nextLine();
        System.out.println("*********************** Tìm kiếm nhà cung cấp ***********************");
        if (dsncc.size() == 0)
        {
            System.out.println("Danh sách rỗng hãy nhập thêm nhà cung cấp để thực hiện chức năng!");
        }
        else
        {
            System.out.print("Nhập ID nhà cung cấp hoặc tên nhà cung cấp cần tìm: ");
            timkiem = scanner.nextLine();
            for (NhaCungCap nhaCungCap : dsncc)
            {
                if (nhaCungCap.getID().compareToIgnoreCase(timkiem) == 0 || nhaCungCap.getID().compareToIgnoreCase(timkiem) == 0 ) {
                    check = true;
                    System.out.print(nhaCungCap);
                }
            }
            if (!check)
            {
                System.out.println("Không tìm thấy ID nhà cung cấp đã nhập!");
            }
        }
    }

    void sapxepnhachungcap()
    {
        Collections.sort(dsncc);
        docghi.GhiFileNhaCungCap("nhacungcap.txt", dsncc);
        System.out.println("Sắp xếp thành công!");
    }

    void display()
    {
        System.out.println("*********************** Đọc file nhà cung cấp ***********************");
        if (dsncc.size() == 0)
        {
            System.out.println("Danh sách rỗng hãy nhập thêm nhà cung cấp để thực hiện chức năng!");
        }
        else {
            System.out.printf("%-20s|%-10s|%-20s|%-10s|%-35s|\n", "Tên NCC", "Mã NCC", "Địa Chỉ", "SĐT", "Email");
            docghi.docFile("nhacungcap.txt");
        }
    }
}
