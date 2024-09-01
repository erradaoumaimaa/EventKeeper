package interfaces;

import model.Participant;

import java.util.List;

public interface InterfaceParticipant {

    Participant addParticipant(Participant participant);

    List<Participant> getAllParticipant();

    Participant updateParticipant(Participant participant);

    Participant deleteParticipant(Participant participant);
}
