This example is described in the Description text file
It tends to use the Adventure Game example from the Collection examples to implement IO
We use FileReader(extends the InputStreamReader) to read the directions (stream of characters)
from a directions text file
We wrap the FileReader object with a BuffetReader to increase the read characters ability
since the Buffer capacity is 8K. Then we warp the BufferReader with a Scanner Object
When closing the scanner stream, the FileReader stream will close automatically
because the Scanner implements the closeable interface which makes
sure that the stream is closed after writing or reading
