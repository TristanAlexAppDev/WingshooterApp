package com.example.alex.wingshooterspocketapplication;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

import android.content.Context;
import android.widget.Toast;

/*
 * This class is for text file CRUD.
 * You can just make flashMessage() a comment if you do not need it.
 */
public class TextFileHelper {

    // context is used for toasts
    Context mContext;

    /*
     * Constructor
     */
    public TextFileHelper(Context mContext) {
        this.mContext = mContext;
    }

    /*
     * Create a text file.
     */
    public void createTextFile(String actualFile) {
        try {

            File file = new File(actualFile);

            if (file.exists()) {
                flashMessage("Text file already exists.");
            } else {

                // create the text file
                if (file.createNewFile()) {
                    flashMessage("Text file was created.");
                } else {
                    flashMessage("Unable to create text file.");
                }

            }

        } catch (NullPointerException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /*
     * Read a text file.
     */
    public String readTextFile(String actualFile) {

        String contents = "";

        try {

            // Get the text file
            File file = new File(actualFile);

            // check if file is not empty
            if (file.exists() && file.length() != 0) {

                // read the file to get contents
                BufferedReader br = new BufferedReader(new FileReader(file));
                String line;

                while ((line = br.readLine()) != null) {
                    // store the text file line to contents variable
                    contents += line + "n";
                }

            } else {
                flashMessage("Unable to read. File may be missing or empty.");
            }

        } catch (NullPointerException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return contents;
    }

    /*
     * Update a text file.
     */
    public void updateTextFile(String actualFile, String contents) {
        try {

            File textFile = new File(actualFile);

            if (textFile.exists()) {

                // set to true if you want to append contents to text file
                // set to false if you want to remove preivous content of text
                // file
                FileWriter textFileWriter = new FileWriter(textFile, false);

                BufferedWriter out = new BufferedWriter(textFileWriter);

                // create the content string
                String contentString = new String(contents);

                // write the updated content
                out.write(contentString);
                out.close();

                flashMessage("File was updated.");

            } else {
                flashMessage("Cannot update. File does not exist.");
            }

        } catch (NullPointerException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /*
     * Delete a text file.
     */
    public void deleteTextFile(String actualFile) {
        try {

            File file = new File(actualFile);

            if (file.exists()) {

                if (file.delete()) {
                    flashMessage("Text file was deleted!");
                } else {
                    flashMessage("Unable to delete text file.");
                }

            } else {
                flashMessage("Unable to delete. File does not exist.");
            }

        } catch (NullPointerException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /*
     * Method to create path where our text file will be created.
     */
    public void createPath(String filePath) {
        try {

            File file = new File(filePath);

            if (file.isDirectory()) {
                flashMessage("Path exists.");
            }

            // create the directory
            else {
                if (file.mkdirs()) {
                    flashMessage("Path was created.");
                } else {
                    flashMessage("Unable to create path.");
                }

            }

        } catch (NullPointerException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /*
     * Just an extra method for displaying toasts.
     */
    public void flashMessage(String customText) {
        try {

            Toast.makeText(mContext, customText, Toast.LENGTH_SHORT).show();

        } catch (NullPointerException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
