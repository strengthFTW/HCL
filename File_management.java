/*
1. File Management System

Problem Statement:
Design a FileManager class to manage files and folders using a HashMap.

The FileManager should support:
1. Creating folders.
2. Checking whether a folder exists.
3. Saving files inside folders.

The root folder is represented by "/".

The HashMap stores:
    folder name -> list of files in that folder

Input Format:
- First line: integer n (number of commands).
- Next n lines contain one of the following commands:

FOLDER folderName
    -> Create the specified folder.

CHECK folderName
    -> Check whether the specified folder exists.

SAVE fileName folderName
    -> Save the specified file inside the folder.

Output Format:
- Print the result/action performed for each command.

Sample Input:
3
SAVE statements1.txt /
SAVE statements2.txt /work/documents
SAVE statements3.txt /work/

Sample Output:
uploading file 'statements1.txt' to folder '/'
creating folder '/work/documents'
uploading file 'statements2.txt' to folder '/work/documents'
uploading file 'statements3.txt' to folder '/work/'
*/

import java.util.*;

class FileManager {

    HashMap<String, List<String>> mpp;

    public FileManager() {
        mpp = new HashMap<>();
        mpp.put("/", new ArrayList<>());
    }

    public String createFolder(String folderName) {

        if (!mpp.containsKey(folderName)) {
            mpp.put(folderName, new ArrayList<>());
            return "Created";
        }

        return "Folder exists";
    }

    public String checkFolder(String folderName) {

        if (mpp.containsKey(folderName)) {
            return "True";
        }

        return "False";
    }

    public String saveFile(String fileName, String folderName) {

        if (!mpp.containsKey(folderName)) {
            createFolder(folderName);
        }

        mpp.get(folderName).add(fileName);

        return "Uploaded";
    }
}

public class File_management {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        FileManager fm = new FileManager();

        while (n-- > 0) {

            String command = sc.next();

            if (command.equals("FOLDER")) {

                String folderName = sc.next();

                System.out.println(
                    fm.createFolder(folderName)
                );
            }

            else if (command.equals("CHECK")) {

                String folderName = sc.next();

                System.out.println(
                    fm.checkFolder(folderName)
                );
            }

            else if (command.equals("SAVE")) {

                String fileName = sc.next();
                String folderName = sc.next();

                System.out.println(
                    fm.saveFile(fileName, folderName)
                );
            }
        }

        sc.close();
    }
}