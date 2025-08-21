import java.io.*;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.nio.file.*;

public class FileReader {
    private final Config config;

    public FileReader(Config config) {
        this.config = config;
    }

    public Stats process() {
        Stats stats = new Stats();
        BufferedWriter intOut = null, floatOut = null, strOut = null;

        for (String fileName : config.inputFiles) {
            try (BufferedReader br = Files.newBufferedReader(Paths.get(fileName))) {
                String line;
                while ((line = br.readLine()) != null) {
                    String s = line.strip();

                    if (isInteger(s)) {
                        BigInteger n = new BigInteger(s);
                        if (intOut == null) intOut = openWriter(config.outDir, config.prefix + "integers.txt", config.append);
                        intOut.write(line);
                        intOut.newLine();

                        stats.intCount++;
                        stats.intSum = stats.intSum.add(n);
                        stats.intMin = (stats.intMin == null || n.compareTo(stats.intMin) < 0) ? n : stats.intMin;
                        stats.intMax = (stats.intMax == null || n.compareTo(stats.intMax) > 0) ? n : stats.intMax;
                    }
                    else if (isFloat(s)) {
                        BigDecimal n = new BigDecimal(s);
                        if (floatOut == null) floatOut = openWriter(config.outDir, config.prefix + "flaots.txt", config.append);
                        floatOut.write(line);
                        floatOut.newLine();

                        stats.floatCount++;
                        stats.floatSum = stats.floatSum.add(n);
                        stats.floatMin = (stats.floatMin == null || n.compareTo(stats.floatMin) < 0) ? n : stats.floatMin;
                        stats.floatMax = (stats.floatMax == null || n.compareTo(stats.floatMax) > 0) ? n : stats.floatMax;
                    }
                    else {
                        if (strOut == null) strOut = openWriter(config.outDir, config.prefix + "strings.txt", config.append);
                        strOut.write(line);
                        strOut.newLine();

                        stats.strCount++;
                        int len = s.length();
                        stats.strMinLen = (stats.strMinLen == null || len < stats.strMinLen) ? len : stats.strMinLen;
                        stats.strMaxLen = (stats.strMaxLen == null || len > stats.strMaxLen) ? len : stats.strMaxLen;
                    }
                }
            } catch (IOException e) {
                System.err.println("Произошла ошибка при чтени файлов" + fileName + ": " + e.getMessage());
                System.exit(1);
            }
        }

        try {
            if (intOut != null) intOut.close();
            if (floatOut != null) floatOut.close();
            if (strOut != null) strOut.close();
        } catch (IOException e) {
            System.err.println("Произошла ошибка при закрытии файлов" + e.getMessage());
            System.exit(1);
        }

        return stats;
    }

    private BufferedWriter openWriter(String dir, String name, boolean append) throws IOException {
        Path path = Paths.get(dir, name);
        if (path.getParent() != null) Files.createDirectories(path.getParent());
        return new BufferedWriter(new FileWriter(path.toFile(), append));
    }

    private boolean isInteger(String s) {
        return s.matches("[+-]?\\d+");
    }

    private boolean isFloat(String s) {
        if (isInteger(s)) return false;
        try {
            new BigDecimal(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
