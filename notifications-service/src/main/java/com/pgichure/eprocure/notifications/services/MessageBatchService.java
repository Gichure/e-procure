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

import com.pgichure.eprocure.notifications.dtos.MessageBatchDto;
import com.pgichure.eprocure.notifications.models.MessageBatch;
import com.pgichure.eprocure.notifications.repositories.MessageBatchRepository;

import lombok.RequiredArgsConstructor;

/**
 * @author pgichure
 *
 */
@Service
@RequiredArgsConstructor
public class MessageBatchService implements MessageBatchServiceI{
	
	private final MessageBatchRepository repository;
	
	private final ModelMapper modelMapper;

	@Override
	public MessageBatchDto save(MessageBatchDto messageDto) {
		MessageBatch batch = modelMapper.map(messageDto, MessageBatch.class);
		batch = this.repository.save(batch);
		return modelMapper.map(batch, MessageBatchDto.class);
	}

	@Override
	public MessageBatchDto findById(Long id) throws Exception {
		MessageBatch batch = repository.findById(id).orElseThrow(() -> new Exception("MessageBatch not found - " + id));
		return modelMapper.map(batch, MessageBatchDto.class);
	}

	@Override
	public MessageBatchDto update(Long id, MessageBatchDto messageDto) {
		if(!Objects.equals(id, messageDto.getId())){
            throw new IllegalArgumentException("IDs don't match");
        }
		MessageBatch batch = modelMapper.map(messageDto, MessageBatch.class);
		
		batch = this.repository.save(batch);
		return modelMapper.map(batch, MessageBatchDto.class);
	}

	@Override
	public List<MessageBatchDto> findAll(int page, int size, String sortDir, String sort) {
		PageRequest pageRequest = PageRequest.of(page, size, Sort.by(sort));
		List<MessageBatch> messages = repository.findAll(pageRequest).getContent();
		return messages.stream().map(batch -> modelMapper.map(batch, MessageBatchDto.class))
				.collect(Collectors.toList());
	}

	@Override
	public MessageBatchDto delete(Long id) throws Exception {
		MessageBatch batch = repository.findById(id).orElseThrow(() -> new Exception("MessageBatch not found - " + id));
		repository.delete(batch);
		return modelMapper.map(batch, MessageBatchDto.class);
	}
	
}
