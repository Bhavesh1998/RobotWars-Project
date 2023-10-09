/**
 * Exception Class For Robot Wars Project which is scalable and parent to other exception classes
 */

package exceptions;

public class RobotException extends Exception {
    public RobotException(String message) {
        super(message);
    }
}
