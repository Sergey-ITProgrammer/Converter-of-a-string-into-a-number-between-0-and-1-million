import java.util.*;

public class Parser {
    public static void main (String[] args) {

    }

    public static int parseInt(String numStr) {
        if (numStr.equals("one million")) return 1000000;

        String[] arrStr = numStr.split(" ");
        ArrayList<String> arr1 = new ArrayList<>(Arrays.asList(arrStr));
        for (int i = 0; i < arr1.size(); i++) {
            if (arr1.get(i).endsWith("y") && i < arr1.size() - 1) {
                arr1.set(i, arr1.get(i) + "-" + arr1.get(i+1));
                arr1.remove(i+1);
            }
        }
        arrStr = arr1.toArray(String[]::new);

        int num = 0;

        if (arrStr.length == 1) {
            if (arrStr[0].contains("-")) {
                String[] arr = arrStr[0].split("-");

                num = Integer.parseInt(parseInt1to99(arr[0]) + "0") + parseInt1to99(arr[1]);
            }
            else if (arrStr[0].endsWith("y")) num = Integer.parseInt(parseInt1to99(arrStr[0]) + "0");
            else if (arrStr[0].endsWith("teen") || arrStr[0].equals("twelve")) num = Integer.parseInt("1" + parseInt1to99(arrStr[0]));
            else num = parseInt1to99(arrStr[0]);
            return num;
        }

        for (int i = 0; i < arrStr.length; i++) {
            if (arrStr[i].equals("thousand")) {
                if (i == 4) {
                    int n = 0;

                    n += Integer.parseInt(parseInt1to99(arrStr[i - 4]) + "00");

                    if (arrStr[i-1].contains("-")) {
                        String[] arr = arrStr[i-1].split("-");

                        n += Integer.parseInt(parseInt1to99(arr[0]) + "0") + parseInt1to99(arr[1]);
                    }
                    else if (arrStr[i-1].endsWith("y")) n += Integer.parseInt(parseInt1to99(arrStr[i-1]) + "0");
                    else if (arrStr[i-1].endsWith("teen") || arrStr[i-1].equals("twelve")) n += Integer.parseInt("1" + parseInt1to99(arrStr[i-1]));
                    else n += parseInt1to99(arrStr[i-1]);

                    num = Integer.parseInt(n + "000");
                }
                if (i == 3) {
                    int n = 0;

                    n += Integer.parseInt(parseInt1to99(arrStr[i - 3]) + "00");

                    if (arrStr[i-1].contains("-")) {
                        String[] arr = arrStr[i-1].split("-");

                        n += Integer.parseInt(parseInt1to99(arr[0]) + "0") + parseInt1to99(arr[1]);
                    }
                    else if (arrStr[i-1].endsWith("y")) n += Integer.parseInt(parseInt1to99(arrStr[i-1]) + "0");
                    else if (arrStr[i-1].endsWith("teen") || arrStr[i-1].equals("twelve")) n += Integer.parseInt("1" + parseInt1to99(arrStr[i-1]));
                    else n += parseInt1to99(arrStr[i-1]);

                    num = Integer.parseInt(n + "000");
                }
                if (i == 2) {
                    int n = 0;
                    n = Integer.parseInt(parseInt1to99(arrStr[i - 2]) + "00");
                    num = Integer.parseInt(n + "000");
                }
                if (i == 1) {
                    int n = 0;
                    if (arrStr[i-1].contains("-")) {
                        String[] arr = arrStr[i-1].split("-");

                        n += Integer.parseInt(parseInt1to99(arr[0]) + "0") + parseInt1to99(arr[1]);
                    } else {
                        if (arrStr[i-1].endsWith("y")) n = Integer.parseInt(parseInt1to99(arrStr[i-1]) + "0");
                        else if (arrStr[i-1].endsWith("teen") || arrStr[i-1].equals("twelve")) n = Integer.parseInt("1" + parseInt1to99(arrStr[i-1]));
                        else n = parseInt1to99(arrStr[i-1]);
                    }
                    num = Integer.parseInt(n + "000");
                }

                if (arrStr.length - i > 2) {
                    if (arrStr[i+2].equals("hundred")) {
                        num += Integer.parseInt(parseInt1to99(arrStr[i + 1]) + "00");

                        if (arrStr.length - i > 3) {
                            if (arrStr[i + 3].equals("and")) {
                                if (arrStr[i+4].contains("-")) {
                                    String[] arr = arrStr[i+4].split("-");

                                    num += Integer.parseInt(parseInt1to99(arr[0]) + "0") + parseInt1to99(arr[1]);
                                }
                                else if (arrStr[i + 4].endsWith("y"))
                                    num += Integer.parseInt(parseInt1to99(arrStr[i + 4]) + "0");
                                else if (arrStr[i + 4].endsWith("teen") || arrStr[i+4].equals("twelve"))
                                    num += Integer.parseInt("1" + parseInt1to99(arrStr[i + 4]));
                                else num += parseInt1to99(arrStr[i + 4]);
                            }
                            else if (arrStr[i+3].contains("-")) {
                                String[] arr = arrStr[i+3].split("-");

                                num += Integer.parseInt(parseInt1to99(arr[0]) + "0") + parseInt1to99(arr[1]);
                            }
                            else if (arrStr[i + 3].endsWith("y"))
                                num += Integer.parseInt(parseInt1to99(arrStr[i + 3]) + "0");
                            else if (arrStr[i + 3].endsWith("teen") || arrStr[i+3].equals("twelve"))
                                num += Integer.parseInt("1" + parseInt1to99(arrStr[i + 3]));
                            else num += parseInt1to99(arrStr[i + 3]);
                        }
                    }
                    if (arrStr[i + 1].equals("and")) {
                        if (arrStr[i+2].contains("-")) {
                            String[] arr = arrStr[i+2].split("-");

                            num += Integer.parseInt(parseInt1to99(arr[0]) + "0") + parseInt1to99(arr[1]);
                        }
                        else if (arrStr[i + 2].endsWith("y"))
                            num += Integer.parseInt(parseInt1to99(arrStr[i + 2]) + "0");
                        else if (arrStr[i + 2].endsWith("teen") || arrStr[i+2].equals("twelve"))
                            num += Integer.parseInt("1" + parseInt1to99(arrStr[i + 2]));
                        else num += parseInt1to99(arrStr[i + 2]);
                    }
                    return num;
                }
                if (arrStr.length - i > 1) {
                    if (arrStr[i+1].contains("-")) {
                        String[] arr = arrStr[i+1].split("-");

                        num += Integer.parseInt(parseInt1to99(arr[0]) + "0") + parseInt1to99(arr[1]);
                    }
                    else if (arrStr[i+1].endsWith("y")) num += Integer.parseInt(parseInt1to99(arrStr[i+1]) + "0");
                    else if (arrStr[i+1].endsWith("teen") || arrStr[i+1].equals("twelve")) num += Integer.parseInt("1" + parseInt1to99(arrStr[i+1]));
                    else num += parseInt1to99(arrStr[i+1]);
                }

                return num;
            }


            if (arrStr[i].equals("hundred")) {
                num += Integer.parseInt(parseInt1to99(arrStr[i - 1]) + "00");
                if (arrStr.length > 2) {
                    if (arrStr[i+1].contains("-")) {
                        String[] arr = arrStr[i+1].split("-");

                        num += Integer.parseInt(parseInt1to99(arr[0]) + "0") + parseInt1to99(arr[1]);
                    }
                    else if (arrStr[i+1].equals("and")) {
                        if (arrStr[i+2].contains("-")) {
                            String[] arr = arrStr[i+2].split("-");

                            num += Integer.parseInt(parseInt1to99(arr[0]) + "0") + parseInt1to99(arr[1]);
                        }
                        else if (arrStr[i+2].endsWith("y")) num += Integer.parseInt(parseInt1to99(arrStr[i+2]) + "0");
                        else if (arrStr[i+2].endsWith("teen") || arrStr[i+2].equals("twelve")) num += Integer.parseInt("1" + parseInt1to99(arrStr[i+2]));
                        else num += parseInt1to99(arrStr[i+2]);
                    } else {
                        if (arrStr[i+1].contains("-")) {
                            String[] arr = arrStr[i+1].split("-");

                            num += Integer.parseInt(parseInt1to99(arr[0]) + "0") + parseInt1to99(arr[1]);
                        }
                        else if (arrStr[i+1].endsWith("y")) num += Integer.parseInt(parseInt1to99(arrStr[i+1]) + "0");
                        else if (arrStr[i+1].endsWith("teen") || arrStr[i+1].equals("twelve")) num += Integer.parseInt("1" + parseInt1to99(arrStr[i+1]));
                        else num += parseInt1to99(arrStr[i+1]);
                    }
                }
            }
        }

        return num;
    }

    public static int parseInt1to99 (String numStr) {
        if(numStr.startsWith("thou")) return 1000;
        if(numStr.startsWith("ze")) return 0;
        if(numStr.startsWith("on")) return 1;
        if(numStr.startsWith("tw")) return 2;
        if(numStr.startsWith("th")) return 3;
        if(numStr.startsWith("fo")) return 4;
        if(numStr.startsWith("fi")) return 5;
        if(numStr.startsWith("si")) return 6;
        if(numStr.startsWith("se")) return 7;
        if(numStr.startsWith("ei")) return 8;
        if(numStr.startsWith("ni")) return 9;
        if(numStr.startsWith("te")) return 10;
        if(numStr.startsWith("el")) return 11;
        if(numStr.startsWith("hun")) return 100;
        if(numStr.startsWith("mill")) return 1000000;
        return -1;
    }
}
