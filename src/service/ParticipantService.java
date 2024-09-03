package service;

import model.Participant;
import interfaces.InterfaceParticipant;

import java.util.LinkedList;
import java.util.List;

public class ParticipantService implements InterfaceParticipant {
    private int nextId = 1;
    private List<Participant> participants = new LinkedList<>();

    @Override
    public Participant addParticipant(Participant participant) {
        participant.setId(nextId++);
        participants.add(participant);
        return participant;
    }

    @Override
    public List<Participant> getAllParticipant() {
        return participants;
    }

    @Override
    public Participant updateParticipant(Participant newParticipant) {
        for (int i = 0; i < participants.size(); i++) {
            if (participants.get(i).getId() == newParticipant.getId()) {
                Participant p = participants.get(i);
                p.setName(newParticipant.getName());
                p.setPhoneNumber(newParticipant.getPhoneNumber());
                return p;
            }
        }
        return null;
    }


    @Override
    public Participant deleteParticipant(Participant participant) {
        for (int i = 0; i < participants.size(); i++) {
            if (participants.get(i).getId() == participant.getId()) {
                return participants.remove(i);
            }
        }
        return null;
    }

    public Participant getParticipantById(int id) {
        for (Participant participant : participants) {
            if (participant.getId() == id) {
                return participant;
            }
        }
        return null;
    }

}
