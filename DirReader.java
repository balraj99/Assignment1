import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.*;

public class DirReader {

    public static void searchDirectory(String dirPath, String regex){

        try {

            Pattern pattern = Pattern.compile(regex);

            File folder = new File(dirPath);

            /* List files present in the directory */
            File[] files = folder.listFiles();
            List<File> fileList = new ArrayList<File>(Arrays.asList(files));

            if(files == null){

                System.err.println("Folder not found");

                return;
            }

            while(!fileList.isEmpty()){

                File file = fileList.get(0);
                fileList.remove(0);
                if (file.isFile()) {

                    if (Pattern.matches(regex, file.getName())) {

                        System.out.println("File name = " + file.getAbsolutePath());
                    }
                }else{

                    fileList.addAll(Arrays.asList(file.listFiles()));
                }

            }

        }catch (Exception ex){

            System.err.println("Exception" + ex);
        }
    }

    public static void main(String[] args) {

        try{
            Scanner scan = new Scanner(System.in);

            while(true){


                System.out.println("Enter directory to search:");
                String dir = scan.next();

                System.out.println("Enter regular expression to search for:");
                String regex = scan.next();

                searchDirectory(dir, regex);

                System.out.println("Do you want to continue (Y/N):");
                String input = scan.next();

                if(input.equalsIgnoreCase("N"))
                    break;

            }



        }catch(Exception ex){

        }

    }
}

