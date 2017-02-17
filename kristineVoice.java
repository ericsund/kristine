/*******************************************************************************
Voce
Copyright (C) 2005
Tyler Streeter  tylerstreeter@gmail.com
All rights reserved.
Web: voce.sourceforge.net
*******************************************************************************/

/*******************************************************************************
KristineVoice.java
Copyright (C) 2017
Eric Sund  epsund@gmail.com
All rights reserved.
*******************************************************************************/

/*******************************************************************************
Redistribution and use in source and binary forms, with or without modification,
are permitted provided that the following conditions  are met:

* Redistributions of source code must retain the above copyright notice, this
list of conditions and the following disclaimer.

* Redistributions in binary form must reproduce the above copyright notice, this
list of conditions and the following disclaimer in the documentation and/or
other materials provided with the distribution.

* Neither the name of Voce's copyright owners nor the names of its contributors
may be used to endorse or promote products derived from this software without
specific prior written permission.

THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR
ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
(INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON
ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
(INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
*******************************************************************************/

import java.io.*;

public class kristineVoice {
	public static void main(String[] argv) {

		//set up Voce
		voce.SpeechInterface.init("./lib", true, true,
			"./grammar", "lang");

		boolean change = false; //"switch" spoken to change to text input
		boolean sleep = false;  //"sleep" spoken to quit Kristine

		voce.SpeechInterface.synthesize("Hello, Kristine here.");
		try {Runtime.getRuntime().exec("figlet Kristine");}
		catch (IOException e) {System.out.println(e);}

		while (!sleep) { //Kristine is on

			try {Thread.sleep(250);}
			catch (InterruptedException e){}

			//keep grabbing input
			while (voce.SpeechInterface.getRecognizerQueueSize() > 0) {
				//get a string from the queue that's in the grammar file
				String s = voce.SpeechInterface.popRecognizedString();

				//When string has "quit"
				if (-1 != s.indexOf("sleep")) {
					sleep = true;
				}

				//When string has "switch"
				if (-1 != s.indexOf("switch")) {
					voce.SpeechInterface.synthesize("Switching to text input.");
					System.out.println("Switching to text input.");
					//sleep = true;
				}

				else {
					System.out.println("You just spoke: " + s);
					voce.SpeechInterface.synthesize("You just spoke " + s);
				}

			}
		}

		//switch to text input
		if (change == true) {
			//end this application and start the text version
			voce.SpeechInterface.destroy();
			System.exit(0);
		}

		//switch wasn't spoken, so just end this application
		voce.SpeechInterface.destroy();
		System.exit(0);
	}
}
