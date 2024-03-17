package pl.wipb.cb;


import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/messages")
public class MessageResource {

    private final MessageService messageService;

    public MessageResource(MessageService messageService) {
        this.messageService = messageService;
    }


    @GetMapping
    public List<Message> findAll() {
        return messageService.getAllMessages();
    }

    @GetMapping("/{id}")
    public Message findById(@PathVariable("id") Long id) {
        return messageService.getMessagesById(id);
    }

    @PostMapping
    public Message save(@RequestBody Message message) {
        return messageService.addMessage(message);
    }

    @PutMapping
    public Message update(@RequestBody Message message) {
        return messageService.updateMessage(message);
    }


    @DeleteMapping
    public void delete(@RequestParam Long id) {
        messageService.delete(id);
    }

}



