package com.nhlstenden.JabberPoint.command;

import static org.mockito.Mockito.*;

import com.nhlstenden.JabberPoint.presentation.Presentation;
import java.lang.reflect.InvocationTargetException;
import javax.swing.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;

class GoToCommandTest {
  @Mock private Presentation presentation;
  @InjectMocks private MockGoToCommand goToCommand;

  @BeforeEach
  void setUp() {
    MockitoAnnotations.openMocks(this);
    goToCommand = spy(new MockGoToCommand(presentation));
    doNothing()
        .when(goToCommand)
        .showMessageDialog(any(JFrame.class), anyString(), anyString(), anyInt());
  }

  @Test
  void testExecuteWithValidInput_assertEquals_2()
      throws InterruptedException, InvocationTargetException {
    doReturn(5).when(presentation).getSize();
    doReturn("2").when(goToCommand).getUserInputDialog();

    // Execute the method under test
    SwingUtilities.invokeAndWait(() -> goToCommand.execute());

    verify(presentation).setSlideNumber(1);
  }

  @Test
  void testExecuteWithInvalidInput_assertDoesNotEqual_0()
      throws InterruptedException, InvocationTargetException {
    doReturn("").when(goToCommand).getUserInputDialog();
    doReturn(10).when(presentation).getSize();
    goToCommand.execute();
    verify(goToCommand)
        .showMessageDialog(
            eq(null), eq("Invalid page number"), eq("Error"), eq(JOptionPane.ERROR_MESSAGE));

    doReturn("11").when(goToCommand).getUserInputDialog();
    doReturn(10).when(presentation).getSize();

    // Execute the method under test
    goToCommand.execute();
    verify(goToCommand)
        .showMessageDialog(
            eq(null),
            eq("Invalid page number, Out of range"),
            eq("Error"),
            eq(JOptionPane.ERROR_MESSAGE));
  }

  private static class MockGoToCommand extends GoToCommand {

    public MockGoToCommand(Presentation presentation) {
      super(presentation);
    }

    @Override
    protected void showMessageDialog(JFrame frame, String message, String title, int messageType) {
      // Do nothing
    }
  }
}
