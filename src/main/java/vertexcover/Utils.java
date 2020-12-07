package vertexcover;

public class Utils {
    public static int convertToInteger(String binary) throws Exception {
        if (binary != null) {
            return Integer.parseInt(binary.toLowerCase().replace("v", ""), 2);
        }
        throw new Exception("coding string can not parsed");
    }
}
