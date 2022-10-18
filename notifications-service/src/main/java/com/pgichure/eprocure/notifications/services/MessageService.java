/**
 * 
 */
package com.pgichure.eprocure.notifications.services;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.pgichure.eprocure.notifications.dtos.MessageDto;
import com.pgichure.eprocure.notifications.enums.YesNo;
import com.pgichure.eprocure.notifications.models.Message;
import com.pgichure.eprocure.notifications.models.MessageBatch;
import com.pgichure.eprocure.notifications.repositories.MessageBatchRepository;
import com.pgichure.eprocure.notifications.repositories.MessageRepository;

import lombok.RequiredArgsConstructor;

/**
 * @author pgichure
 *
 */
@Service
@RequiredArgsConstructor
public class MessageService implements MessageServiceI{
	
	private final MessageRepository repository;
	
	private final MessageBatchRepository messageBatchRepository;
	
	private final ModelMapper modelMapper;

	@Override
	public MessageDto save(MessageDto messageDto) {
		
		Message message = modelMapper.map(messageDto, Message.class);
		
		MessageBatch batch = MessageBatch.builder()
				.dateSent(messageDto.getDateSent())
				.messageType(messageDto.getMessageType())
				.sendAsBatch(YesNo.NO)
				.sentBy(messageDto.getSender())
				.companyId(messageDto.getCompanyId())
				.build();
		
		batch = messageBatchRepository.save(batch);
		
		message.setBatch(batch);
		
		message = this.repository.save(message);
		return modelMapper.map(message, MessageDto.class);
	}

	@Override
	public MessageDto findById(Long id) throws Exception {
		Message message = repository.findById(id).orElseThrow(() -> new Exception("Message not found - " + id));
		return modelMapper.map(message, MessageDto.class);
	}

	@Override
	public MessageDto update(Long id, MessageDto messageDto) {
		if(!Objects.equals(id, messageDto.getId())){
            throw new IllegalArgumentException("IDs don't match");
        }
		Message message = modelMapper.map(messageDto, Message.class);
		
		message = this.repository.save(message);
		return modelMapper.map(message, MessageDto.class);
	}

	@Override
	public List<MessageDto> findAll(int page, int size, String sortDir, String sort) {
		PageRequest pageRequest = PageRequest.of(page, size, Sort.by(sort));
		List<Message> messages = repository.findAll(pageRequest).getContent();
		return messages.stream().map(message -> modelMapper.map(message, MessageDto.class))
				.collect(Collectors.toList());
	}

	@Override
	public MessageDto delete(Long id) throws Exception {
		Message message = repository.findById(id).orElseThrow(() -> new Exception("Message not found - " + id));
		repository.delete(message);
		return modelMapper.map(message, MessageDto.class);
	}
	
}
