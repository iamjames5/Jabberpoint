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

  @Mock private Presentation presentation;
  @Mock private Frame parent;
  //  @InjectMocks private AboutCommandTest.MockAboutCommand mockAboutCommand;
  @InjectMocks private AboutCommand aboutCommand;

  @BeforeEach
  void setUp() {
    MockitoAnnotations.openMocks(this);
    aboutCommand = spy(new AboutCommand(presentation, parent));
  }

  @Test
  public void testExecute_assertDoesNotThrow_noExceptionThrown() {
    aboutCommand.setParent(parent);
    doNothing()
        .when(aboutCommand)
        .showMessageDialog(any(Frame.class), anyString(), anyString(), anyInt());

    assertDoesNotThrow(aboutCommand::execute);

    verify(aboutCommand, times(1))
        .showMessageDialog(any(Frame.class), anyString(), anyString(), anyInt());
  }

  @Test
  public void testGetParent_assertEquals_parent() {
    Frame parent = new Frame();
    aboutCommand.setParent(parent);
    assertEquals(parent, aboutCommand.getParent());
  }
}
