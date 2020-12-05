import java.util.ArrayList;

public class Passport {
    ArrayList<String> fieldTitles = new ArrayList<>();
    int byr;
    int iyr;
    int eyr;
    String hgt;
    String hcl;
    String ecl;
    String pid;
    String cid;

    void getFieldTitles(String[] fields) {
        for (int i = 0; i < fields.length; i++) {
            String s = fields[i];
            String[] split = s.split(":");
            String title = split[0];

            switch (title) {
                case "byr":
                    this.byr = Integer.parseInt(split[1]);
                    break;
                case "iyr":
                    this.iyr = Integer.parseInt(split[1]);
                    break;
                case "eyr":
                    this.eyr = Integer.parseInt(split[1]);
                    break;
                case "hgt":
                    this.hgt = split[1];
                    break;
                case "hcl":
                    this.hcl = split[1];
                    break;
                case "ecl":
                    this.ecl = split[1];
                    break;
                case "pid":
                    this.pid = split[1];
                    break;
                case "cid":
                    this.cid = split[1];
                    break;
                default:
                    break;
            }

            this.fieldTitles.add(title);
        }
    }

    boolean hasAllFields() {
        return (this.fieldTitles.contains("byr") && this.fieldTitles.contains("iyr") && this.fieldTitles.contains("eyr")
                && this.fieldTitles.contains("hgt") && this.fieldTitles.contains("hcl")
                && this.fieldTitles.contains("ecl") && this.fieldTitles.contains("pid"));
    }

    boolean isValid() {
        return (this.validBYR() && this.validIYR() && this.validEYR() && this.validHGT() && this.validHCL()
                && this.validECL() && this.validPID());
    }

    boolean validBYR() {
        return (1920 <= this.byr && this.byr <= 2002);
    }

    boolean validIYR() {
        return (2010 <= this.iyr && this.iyr <= 2020);
    }

    boolean validEYR() {
        return (2020 <= this.eyr && this.eyr <= 2030);
    }

    boolean validHGT() {
        String units = this.hgt.substring(this.hgt.length() - 2);
        int height;
        if (units.equals("cm")) {
            height = Integer.parseInt(this.hgt.substring(0, this.hgt.length() - 2));
            return (150 <= height && height <= 193);
        } else if (units.equals("in")) {
            height = Integer.parseInt(this.hgt.substring(0, this.hgt.length() - 2));
            return (59 <= height && height <= 76);
        } else {
            return false;
        }
    }

    boolean validHCL() {
        return (this.hcl.matches("#{1}[0-9a-f]{6}"));
    }

    boolean validECL() {
        String eye = this.ecl;
        return (eye.equals("amb") || eye.equals("blu") || eye.equals("brn") || eye.equals("gry") || eye.equals("grn")
                || eye.equals("hzl") || eye.equals("oth"));
    }

    boolean validPID() {
        return (this.pid.matches("[0-9]{9}"));
    }
}
