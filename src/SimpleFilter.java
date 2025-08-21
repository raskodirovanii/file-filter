public class SimpleFilter {
    public static void main(String[] args) {
        Config config = parseArgs(args);
        if (config.inputFiles.isEmpty()) {
            System.out.println("Ошибка нет входных файлов");
            System.exit(1);
            return;
        }

        FileReader processor = new FileReader(config);
        Stats stats = processor.process();

        StatsPrinter.print(stats, config.fullStats);
    }

    private static Config parseArgs(String[] args) {
        Config config = new Config();
        for (int i = 0; i < args.length; i++) {
            switch (args[i]) {
                case "-o": config.outDir = args[++i]; break;
                case "-p": config.prefix = args[++i]; break;
                case "-a": config.append = true; break;
                case "-f": config.fullStats = true; break;
                case "-s": config.fullStats = false; break;
                default:
                    if (!args[i].startsWith("-")) {
                        config.inputFiles.add(args[i]);
                    } else {
                        System.err.println("Ошибка Неизвестный аргумент: " + args[i]);
                        System.exit(1);
                    }
            }
        }
        return config;
    }
}
