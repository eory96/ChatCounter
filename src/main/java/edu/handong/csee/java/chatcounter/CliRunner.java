package edu.handong.csee.java.chatcounter;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;
/**
 * CLI class provides the option -i,-o,-h,-c
 * -i option is receive input data path name
 * -o option is result file path
 * -h option tells you how to use it
 * -c option receive how many use threads 
 * @author gimdaegyo
 *
 */

public class CliRunner {
	/**
	 * receive thread number
	 */
	String countThread;
	/**
	 * received input path from RunnerOfChatCounter class (args[1])
	 */
	String inputPath;
	/**
	 * Get the save path for the resulting file
	 */
	String outputPath;
	/**
	 * if typing -h,--help with ./Chatcounter you can read how to use it\n
	 * and, you did not follow cmd command form you will get help message
	 */
	boolean help;

	/**
	 * this method have all the necessary methods for the user
	 * get args(from user) and option people can use cmd command with option
	 * @param args
	 */
	public void run(String[] args) {
		Options options = createOptions();

		if(parseOptions(options, args)){
			if (help){
				printHelp(options);
				return;
			}
		}
	}

	private boolean parseOptions(Options options, String[] args) {
		CommandLineParser parser = new DefaultParser();

		try {

			CommandLine cmd = parser.parse(options, args);
			
			countThread = cmd.getOptionValue("c");
			inputPath = cmd.getOptionValue("i");
			outputPath = cmd.getOptionValue("o");
			help = cmd.hasOption("h");

		} catch (Exception e) {
			printHelp(options);
			return false;
		}

		return true;
	}

	private Options createOptions() {
		Options options = new Options();

		options.addOption(Option.builder("i").longOpt("input")
				.desc("Set a path of a directory that input data")
				.hasArg()
				.argName("input option")
				.required()
				.build());

		options.addOption(Option.builder("o").longOpt("output")
				.desc("Set a path of a directory that ouput data")
				.hasArg()
				.argName("output option")
				.required()
				.build());
		
		options.addOption(Option.builder("c").longOpt("count")
				.desc("Set a how many threads use for reading data")
				.hasArg()
				.argName("thread option")
				.required()
				.build());

		options.addOption(Option.builder("h").longOpt("help")
				.desc("Help")
				.build());

		return options;
	}

	private void printHelp(Options options) {
		HelpFormatter formatter = new HelpFormatter();
		String header = "CLI program";
		String footer ="\nThis program is count how many time chating on kakao";
		formatter.printHelp("CLIExample", header, options, footer, true);
	}
}