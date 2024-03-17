package pl.wipb.cb;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageService {

    private final MessageRepository messageRepository;

    public MessageService(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    public List<Message> getAllMessages() {
        return messageRepository.findAll();
    }

    public List<Message> getMessagesByUser(User user) {
        return messageRepository.findByUser(user);
    }

    public Message addMessage(Message message) {
        return messageRepository.save(message);
    }

    public Message updateMessage(Message message) {
        Message message1 = messageRepository.findById(message.getId()).orElseThrow();

        message1.setContent(message.getContent());
        return messageRepository.save(message1);
    }

    public Message getMessagesById(Long id) {

        return messageRepository.findById(id).orElseThrow();
    }


    public void delete(Long id) {
        messageRepository.deleteById(id);
    }
}
