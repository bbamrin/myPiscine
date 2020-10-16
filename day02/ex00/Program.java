import java.io.*;
import java.util.*;

public class Program {

    public static byte getHexValue(char i)
    {
        if (i <= '9' && i >= '0')
            return ((byte)(i - '0'));
        if (i <= 'F' && i >= 'A')
            return ((byte)(10 + i - 'A'));
        if (i <= 'f' && i >= 'a')
            return ((byte)(10 + i - 'a'));
        return (0);
    }

    public static List<Character> getFileSig(String path, Integer maxSigLength, Map<List<Character>, List<Byte>> sigMap) throws IOException
    {
        FileInputStream stream = new FileInputStream(path);
        int i;
        ArrayList<Byte> input = new ArrayList<>();
        while ((i = stream.read()) != -1 && maxSigLength > 0) {
            input.add((byte)(i / 16));
            input.add((byte)(i % 16));
            maxSigLength--;
        }
        for (Map.Entry<List<Character>, List<Byte>> entry : sigMap.entrySet())
        {
            int j = 0;
            boolean equal = true;
            for (Byte b : entry.getValue()) {
                if (b != input.get(j)) {
                    equal = false;
                    break;
                }
                j++;
            }
            if (equal)
                return entry.getKey();
        }
        return null;
    }

    public static Map<List<Character>, List<Byte>> getSigMap(String signaturePath) throws IOException {
        Map<List<Character>, List<Byte>> sigMap = null;
        Integer maxSigLength = -1;
        FileInputStream fileInputStream = new FileInputStream(signaturePath);
        List<Character> characterList = new ArrayList<>();
        characterList.toString();
        List<Byte> byteList = new ArrayList<>();
        sigMap = new HashMap<>();
        int i;
        boolean trigger = false;
        while ((i = fileInputStream.read()) != -1) {
            if ((char) i == '\n' || fileInputStream.available() == 0) {
                if (byteList.size() == 0 || characterList.size() == 0)
                    continue;
                if (byteList.size() > maxSigLength)
                    maxSigLength = byteList.size();
                trigger = false;

                sigMap.put(characterList, byteList);
                characterList = new ArrayList<>();
                byteList = new ArrayList<>();
                continue;
            }
            if ((char) i == ',') {
                trigger = true;
                continue;
            }
            if ((char) i == ' ')
                continue;
            if (!trigger)
                characterList.add((char) i);
            else
                byteList.add(getHexValue((char) i));
        }
        return sigMap;
    }

    public static void main(String[] args) {
        Map<List<Character>, List<Byte>> sigMap;
        String signaturePath;
        InputStream inputStream;
        Integer maxSigLength = -1;
        FileOutputStream fout = null;
        int c;
        boolean isOpened = false;

        signaturePath = "";
        while (true)
        {
            try {
                if((c = System.in.read()) == -1)
                    break;
            }
            catch (IOException e)
            {
                System.out.println("UNDEFINED\n");
                return;
            }
            if ((char)c != '\n')
                signaturePath += (char)c;
            else if (signaturePath.equals("42") && (char)c == '\n')
                return;
            try {
                if (!isOpened)
                    fout = new FileOutputStream("result.txt");
                isOpened = true;
            }
            catch (FileNotFoundException e)
            {
                isOpened = false;
                System.out.println("UNDEFINED\n");
                continue;
            }
            if ((char)c == '\n')
            {
                try {
                    sigMap = getSigMap("./signatures.txt");
                    List<Character> ret = getFileSig(signaturePath, 8, sigMap);
                    if (ret == null)
                        System.out.println("UNDEFINED\n");
                    else {
                        for (Character ch : ret)
                            fout.write(ch);
                        fout.write('\n');
                        System.out.println("PROCESSED\n");
                    }
                }
                catch (IOException e)
                {
                    System.out.println("UNDEFINED\n");
                    signaturePath = "";
                    continue;
                }
                signaturePath = "";
            }
        }
    }
}
