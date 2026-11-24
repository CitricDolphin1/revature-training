1. What is the difference between throw and throws?

"throw" is a statement which actually throws an exception; "throws" is used in a method signature to indicate that it *can* throw an exception.

2. Why did the compiler force you to handle AttendanceShortageException but not InvalidMarksException?

Exceptions need to be handled, but RuntimeExceptions do not.

3. When does the finally block run?

After the try block and any relevant catch blocks, in every case.

4. Why is it better to check email == null than to catch NullPointerException?

It is more specific.

5. Name one more custom exception the portal could use, and say whether it should be checked or unchecked.

An InvalidAttendenceException could be useful. It would be unchecked.