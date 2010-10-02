/*
Copyright 2010 C�lio Cidral Junior

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.
*/

package org.tomighty.ui.states;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import org.tomighty.bus.Bus;
import org.tomighty.bus.messages.ChangeUiState;
import org.tomighty.ui.LabelFactory;
import org.tomighty.ui.UiState;

public class PomodoroInterrupted implements UiState, ActionListener {

	@Override
	public Component render() throws Exception {
		JPanel panel = new JPanel();
		panel.setOpaque(false);
		panel.setLayout(new BorderLayout());
		panel.add(text(), BorderLayout.CENTER);
		panel.add(restartButton(), BorderLayout.SOUTH);
		return panel;
	}

	private Component text() {
		return LabelFactory.medium("Pomodoro interrupted");
	}

	private Component restartButton() {
		JButton button = new JButton("Restart");
		button.addActionListener(this);
		return button;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Bus.publish(new ChangeUiState(Pomodoro.class));
	}

}