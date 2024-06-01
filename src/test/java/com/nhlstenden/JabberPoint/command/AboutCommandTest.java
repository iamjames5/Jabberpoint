package com.nhlstenden.JabberPoint.command;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

import com.nhlstenden.JabberPoint.presentation.Presentation;
import java.awt.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class AboutCommandTest {
  
  @Mock
  private Presentation presentation;
  @Mock
  private Frame parent;
  @InjectMocks
  private AboutCommandTest.MockAboutCommand mockAboutCommand;
  private AboutCommand aboutCommand;

  @BeforeEach
  void setUp() {
    MockitoAnnotations.openMocks(this);
    mockAboutCommand = spy(new AboutCommandTest.MockAboutCommand(presentation));
    doNothing().when(mockAboutCommand).showMessageDialog(any(Frame.class), anyString(), anyString(), anyInt());

    aboutCommand = new AboutCommand(presentation);
  }

  @Test
  public void testExecute_assertDoesNotThrow_noExceptionThrown() {

    mockAboutCommand.setParent(parent);

    assertDoesNotThrow(mockAboutCommand::execute);

    verify(mockAboutCommand, times(1)).showMessageDialog(any(Frame.class), anyString(), anyString(), anyInt());
  }

  @Test
  public void testGetParent_assertEquals_parent() {
      Frame parent = new Frame();
      aboutCommand.setParent(parent);
      assertEquals(parent, aboutCommand.getParent());
  }

  private static class MockAboutCommand extends AboutCommand
  {

    public MockAboutCommand(Presentation presentation) {
      super(presentation);
    }

    @Override
    protected void showMessageDialog(Frame frame, String message, String title, int messageType) {
      // Do nothing
    }
  }
}
