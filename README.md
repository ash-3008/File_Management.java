# File_Management.java

FILE UTILITY PROGRAM
====================

Overview:
---------
This is a simple command-line based Java application that allows users to perform basic file operations such as:
1. Read a file
2. Write to a file
3. Append to a file
4. Delete a file

Instructions:
-------------
1. Compile the program using:
   javac FileUtility.java

2. Run the program using:
   java FileUtility

3. Choose an option from the menu:
   - Option 1 (Read File): Reads and displays the content of an existing file.
     NOTE: Make sure the file exists before using this option. You can create one using Option 2 or 3.
   - Option 2 (Write to File): Creates a new file or overwrites an existing file with your input.
   - Option 3 (Append to File): Adds your input to the end of an existing file or creates a new file if it doesn't exist.
   - Option 4 (Delete File): Deletes the specified file from the system.
   - Option 5 (Exit): Closes the program.

Logging:
--------
Every file operation is logged with a timestamp in a file named:
operation_log.txt

This log includes the type of operation (Read, Write, Append, Delete), the file name, and the date/time of the action.

Example:
--------
[2025-05-26 14:12:30] Write: myfile.txt
[2025-05-26 14:13:02] Read: myfile.txt

Author:
-------
This utility was developed as part of a Java Developer internship project.
(Ashutosh Gite)
-------



