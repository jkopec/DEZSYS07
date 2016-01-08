package at.ernhofer.kopec.dezsys07.client;

import org.apache.commons.cli.*;

import static at.ernhofer.kopec.dezsys07.client.Client.*;

public class CLIProcessor {

    public void parseArguments(String[] args) throws ParseException {
        CommandLineParser parser = new DefaultParser();
        Options options = getOptions();

        CommandLine line = parser.parse(options, args);

        // The name option
        if (line.hasOption('n')) {
            NAME = line.getOptionValue('n');
        }

        // The host option
        if (line.hasOption('h')) {
            HOST = line.getOptionValue('h');
        }

        // The port option
        if (line.hasOption('p')) {
            PORT = line.getOptionValue('p');
        }

        // Dump the output to a file or nah
        if (line.hasOption('o')) {
            DUMP_PATH = line.getOptionValue('o');
        }
    }

    public Options getOptions() {

        Options options = new Options();

        Option name = Option.builder("n").argName("name").longOpt("name")
                .desc("The name that is going to be looked up").required().hasArg().build();

        Option host = Option.builder("h").argName("host").longOpt("host")
                .desc("The ip or domain of the application server").hasArg()
                .optionalArg(true).build();

        Option port = Option.builder("p").argName("port").longOpt("port")
                .desc("The port where the application server is running on").hasArg()
                .optionalArg(true).build();

        Option output = Option.builder("o").argName("output").longOpt("output")
                .desc("The file the SOAP response will be dumped to").hasArg()
                .optionalArg(true).build();

        options.addOption(name);
        options.addOption(host);
        options.addOption(port);
        options.addOption(output);

        return options;
    }

    public void printHelp() {
        String header = "Client application to search the web service for entries";
        String footer = "";

        HelpFormatter formatter = new HelpFormatter();
        formatter.printHelp("dezsys07", header, getOptions(), footer, true);
    }
}
