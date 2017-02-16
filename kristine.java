import java.io.BufferedReader;
import java.io.InputStreamReader;

public class kristine
{
	public static void main(String[] argv)
	{
		voce.SpeechInterface.init("../../../lib", true, false, "", "");

		voce.SpeechInterface.synthesize("Hello, Kristine here.");
		voce.SpeechInterface.synthesize("Let me organize myself so I can help you");
		//setup
		voce.SpeechInterface.synthesize("Alright, I'm ready to help.");

		System.out.println("s: Cut Kristine off\nq: Put Kristine to bed");

		BufferedReader console =
			new BufferedReader(new InputStreamReader(System.in));

		try {
			String s = "";
			while (!s.equals("q"))
			{
				s = console.readLine(); //Read input line

				//cut off
				if (s.equals("s")) {
					voce.SpeechInterface.stopSynthesizing();
				}

				else {
					voce.SpeechInterface.synthesize(s); //Speak inputted line
				}
			}
		}

		catch (java.io.IOException ioe) {
			System.out.println( "IO error:" + ioe );
		}

		//put to sleep
		voce.SpeechInterface.destroy();
		System.exit(0);
	}
}
