package DOCGIFLE;



import java.io.*;
import java.util.ArrayList;
import Thanh_Phan.NhaCungCap;
import Thanh_Phan.Sach;
import Thanh_Phan.ThuThu;

public class DocGhiFile
{
    //Hàm ghi danh sách Sách vào 1 file

    public void GhiFileSach(String path, ArrayList<Sach> ds)
    {
        try
        {
            FileOutputStream fileOutputStream = new FileOutputStream(path);
            OutputStreamWriter  outputStreamWriter = new OutputStreamWriter(fileOutputStream);
            BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter);

            for (Sach sach : ds)
            {
                bufferedWriter.write(sach.toString());
            }

            bufferedWriter.close();
            outputStreamWriter.close();
            fileOutputStream.close();
            System.out.println("Ghi vào file sách thành công");
        }
        catch (Exception e)
        {
            System.out.println("Lỗi : " + e.getMessage());
        }
    }

    public void GhiFileNhaCungCap(String path,ArrayList<NhaCungCap> ds)
    {
        try
        {
            FileOutputStream fileOutputStream = new FileOutputStream(path);
            OutputStreamWriter  outputStreamWriter = new OutputStreamWriter(fileOutputStream);
            BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter);

            for (NhaCungCap nhaCungCap : ds)
            {
                bufferedWriter.write(nhaCungCap.toString());
            }

            bufferedWriter.close();
            outputStreamWriter.close();
            fileOutputStream.close();
            System.out.println("Ghi vào file Nhà Cung Cấp thành công");
        }
        catch (Exception e)
        {
            System.out.println("Lỗi: " + e.getMessage());
        }
    }

    public void GhiFileThuThu(String path, ArrayList<ThuThu> ds)
    {
        try
        {
            FileOutputStream fileOutputStream = new FileOutputStream(path);
            OutputStreamWriter  outputStreamWriter = new OutputStreamWriter(fileOutputStream);
            BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter);

            for (ThuThu thuthu : ds)
            {
                bufferedWriter.write(thuthu.toString());
            }

            bufferedWriter.close();
            outputStreamWriter.close();
            fileOutputStream.close();
            System.out.println("Ghi vào file Thủ Thư thành công");
        }
        catch (Exception e) {
            System.out.println("Lỗi: " + e.getMessage());
        }
    }



    public static void docFile(String filename)
    {

        try {
            File file = new File(filename);
            if (file.exists())
            {
                FileInputStream fileInputStream = new FileInputStream(filename);
                InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
                BufferedReader bufferedReader=new BufferedReader(inputStreamReader);
                String doc;
                while ((doc = bufferedReader.readLine())!=null)
                {
                    System.out.println(doc);
                    System.out.println();
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