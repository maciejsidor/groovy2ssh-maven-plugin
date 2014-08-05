
/************************************* 
 * EXAMPLE 1 
 ************************************/

outputLine = '';
while ((outputLine = cmd.readBuffer()) != '$')
{
	print outputLine;
}
print outputLine;

is.sendCommand("ls\n");

while ((outputLine = cmd.readBuffer()) != '$')
{
	print outputLine;
}
print outputLine;


outputLine = "";
/************************************* 
 * EXAMPLE 2
 ************************************/
outputCheck = false;
while ((outputLine = cmd.readBufferString()) != null)
{
	print outputLine;
	
	if(outputLine.endsWith("\$ "))
		outputCheck = true;	
}

if(outputCheck)
	cmd.sendCommand("ls\n");
else
	throw new Exception ("Could not execute LS");
	
outputLine = "";
while ((outputLine = cmd.readBufferString()) != null)
{
	print outputLine;
}

/************************************* 
 * EXAMPLE 3
 ************************************/
outputCheck = false;
lastUpdate=System.currentTimeMillis();
while (System.currentTimeMillis()-lastUpdate<15000 && !outputCheck)
{

	if((outputLine = cmd.readBufferLine()) != null)
	{
		if(outputLine.endsWith("\n"))
			print outputLine;
		
		if(outputLine.endsWith("\$ "))
			outputCheck = true;
	}	
}

if(outputCheck)
	cmd.sendCommand("ls\n");
else
	throw new Exception ("Could not execute LS");			
	
outputCheck = false;	
while (System.currentTimeMillis()-lastUpdate<15000 && !outputCheck)
{

	if((outputLine = cmd.readBufferLine()) != null)
	{
		if(outputLine.endsWith("\n"))
			print outputLine;
		
		if(outputLine.endsWith("\$ "))
			outputCheck = true;
	}	
}				