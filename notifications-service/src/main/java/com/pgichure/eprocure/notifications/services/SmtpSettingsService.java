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

import com.pgichure.eprocure.notifications.dtos.SmtpSettingsDto;
import com.pgichure.eprocure.notifications.models.SmtpSettings;
import com.pgichure.eprocure.notifications.repositories.SmtpSettingsRepository;

import lombok.RequiredArgsConstructor;

/**
 * @author pgichure
 *
 */
@Service
@RequiredArgsConstructor
public class SmtpSettingsService implements SmtpSettingsServiceI{ 
	
	private final SmtpSettingsRepository repository;
	
	private final ModelMapper modelMapper;

	@Override
	public SmtpSettingsDto save(SmtpSettingsDto dto) {
		SmtpSettings settings = modelMapper.map(dto, SmtpSettings.class);
		settings = this.repository.save(settings);
		return modelMapper.map(settings, SmtpSettingsDto.class);
	}

	@Override
	public SmtpSettingsDto findById(Long id) throws Exception {
		SmtpSettings settings = repository.findById(id).orElseThrow(() -> new Exception("Smtp Settings not found - " + id));
		return modelMapper.map(settings, SmtpSettingsDto.class);
	}

	@Override
	public SmtpSettingsDto update(Long id, SmtpSettingsDto dto) {
		if(!Objects.equals(id, dto.getId())){
            throw new IllegalArgumentException("IDs don't match");
        }
		SmtpSettings settings = modelMapper.map(dto, SmtpSettings.class);
		
		settings = this.repository.save(settings);
		return modelMapper.map(settings, SmtpSettingsDto.class);
	}

	@Override
	public List<SmtpSettingsDto> findAll(int page, int size, String sortDir, String sort) {
		PageRequest pageRequest = PageRequest.of(page, size, Sort.by(sort));
		List<SmtpSettings> settings = repository.findAll(pageRequest).getContent();
		return settings.stream().map(stngs -> modelMapper.map(stngs, SmtpSettingsDto.class))
				.collect(Collectors.toList());
	}

	@Override
	public SmtpSettingsDto delete(Long id) throws Exception {
		SmtpSettings settings = repository.findById(id).orElseThrow(() -> new Exception("Smtp Settings not found - " + id));
		repository.delete(settings);
		return modelMapper.map(settings, SmtpSettingsDto.class);
	}

	@Override
	public SmtpSettingsDto getDefaultSettings(Long companyId) throws Exception {
		List<SmtpSettings> list = repository.findAllByCompanyId(companyId);
		
		if(list.size() == 0)
			return null;
		else {
			SmtpSettings settings = list.get(0);
			return modelMapper.map(settings, SmtpSettingsDto.class);
		}
	}
	
	

}
