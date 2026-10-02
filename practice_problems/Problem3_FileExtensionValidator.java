/**
 * Problem 3: File Extension Validator
 * Scenario: Assignment-upload portal validation
 * 
 * Verifies whether an uploaded filename has an accepted extension (pdf, docx, zip)
 * regardless of case.
 */
public class Problem3_FileExtensionValidator {

    /**
     * Validates the file extension against accepted types: pdf, docx, zip.
     * 
     * @param filename The uploaded file name string
     * @return "Accepted" or "Rejected - invalid file type"
     */
    public static String validateFileExtension(String filename) {
        if (filename == null) {
            return "Rejected - invalid file type";
        }

        int lastDotIndex = filename.lastIndexOf('.');
        if (lastDotIndex == -1 || lastDotIndex == filename.length() - 1) {
            return "Rejected - invalid file type";
        }

        String extension = filename.substring(lastDotIndex + 1);

        if (extension.equalsIgnoreCase("pdf") ||
            extension.equalsIgnoreCase("docx") ||
            extension.equalsIgnoreCase("zip")) {
            return "Accepted";
        } else {
            return "Rejected - invalid file type";
        }
    }

    public static void main(String[] args) {
        System.out.println("=== File Extension Validator ===");
        String[] testFiles = {
            "Assignment1.PDF",
            "notes.txt",
            "project_report.DOCX",
            "source_code.zip",
            "archive.tar.gz",
            "noextension"
        };

        for (String file : testFiles) {
            System.out.printf("\"%s\" -> %s%n", file, validateFileExtension(file));
        }
    }
}
