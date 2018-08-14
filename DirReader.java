import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.regex.Pattern;

public class DirReader {

    public static void searchDirectory(String dirPath, String regex){

        try {

            Pattern pattern = Pattern.compile(regex);

            File folder = new File(dirPath);

            /* List files present in the directory */
            File[] files = folder.listFiles();
            if(files == null){

                System.err.println("Folder not found");

                return;
            }
            int len = files.length;

            for (int i = 0; i < len; i++) {

		/* Check if ith value is a file or not */
                if (files[i].isFile()) {

                    if (Pattern.matches(regex, files[i].getName())) {

                        System.out.println("File name = " + files[i].getAbsolutePath());
                    }
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
