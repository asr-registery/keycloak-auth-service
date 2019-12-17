/**
 * 
 */
package af.asr.keycloakauthservice.service.impl;

import af.asr.keycloakauthservice.config.MosipEnvironment;
import af.asr.keycloakauthservice.data.dto.MosipUserDto;
import af.asr.keycloakauthservice.data.dto.otp.OtpGenerateRequest;
import af.asr.keycloakauthservice.data.dto.otp.OtpGenerateRequestDto;
import af.asr.keycloakauthservice.data.dto.otp.OtpGenerateResponseDto;
import af.asr.keycloakauthservice.data.dto.otp.OtpUser;
import af.asr.keycloakauthservice.exception.adapter.AuthNException;
import af.asr.keycloakauthservice.exception.adapter.AuthZException;
import af.asr.keycloakauthservice.exception.common.ExceptionUtils;
import af.asr.keycloakauthservice.exception.common.ServiceError;
import af.asr.keycloakauthservice.exception.keycloak.AuthManagerException;
import af.asr.keycloakauthservice.exception.keycloak.AuthManagerServiceException;
import af.asr.keycloakauthservice.http.RequestWrapper;
import af.asr.keycloakauthservice.http.ResponseWrapper;
import af.asr.keycloakauthservice.service.OTPGenerateService;
import af.asr.keycloakauthservice.util.constant.AuthConstant;
import af.asr.keycloakauthservice.util.constant.AuthErrorCode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.util.List;


@Component
public class OTPGenerateServiceImpl implements OTPGenerateService {

	@Autowired
    RestTemplate restTemplate;

	@Autowired
	MosipEnvironment mosipEnvironment;

	@Autowired
	private ObjectMapper mapper;

	/*
	 * (non-Javadoc)
	 * 
	 * @see io.mosip.kernel.auth.service.OTPGenerateService#generateOTP(io.mosip.
	 * kernel. auth.entities.MosipUserDto, java.lang.String)
	 */
	@Override
	public OtpGenerateResponseDto generateOTP(MosipUserDto mosipUserDto, String token) {
		try {
			List<ServiceError> validationErrorsList = null;
			OtpGenerateResponseDto otpGenerateResponseDto;
			OtpGenerateRequestDto otpGenerateRequestDto = new OtpGenerateRequestDto(mosipUserDto);
			final String url = mosipEnvironment.getGenerateOtpApi();

			RequestWrapper<OtpGenerateRequestDto> reqWrapper = new RequestWrapper<>();
			reqWrapper.setRequesttime(LocalDateTime.now());
			reqWrapper.setRequest(otpGenerateRequestDto);
			HttpHeaders headers = new HttpHeaders();
			headers.set(AuthConstant.COOKIE, AuthConstant.AUTH_HEADER + token);
			HttpEntity<RequestWrapper<OtpGenerateRequestDto>> request = new HttpEntity<>(reqWrapper, headers);
			ResponseEntity<String> response = restTemplate.postForEntity(url, request, String.class);
			validationErrorsList = ExceptionUtils.getServiceErrorList(response.getBody());
			if (!validationErrorsList.isEmpty()) {
				throw new AuthManagerServiceException(validationErrorsList);
			}
			ResponseWrapper<?> responseObject;
			try {
				responseObject = mapper.readValue(response.getBody(), ResponseWrapper.class);
				otpGenerateResponseDto = mapper.readValue(mapper.writeValueAsString(responseObject.getResponse()),
						OtpGenerateResponseDto.class);
			} catch (Exception e) {
				throw new AuthManagerException(AuthErrorCode.RESPONSE_PARSE_ERROR.getErrorCode(),
						AuthErrorCode.RESPONSE_PARSE_ERROR.getErrorMessage(), e);
			}
			return otpGenerateResponseDto;
		} catch (HttpClientErrorException | HttpServerErrorException ex) {
			List<ServiceError> validationErrorsList = ExceptionUtils.getServiceErrorList(ex.getResponseBodyAsString());

			if (ex.getRawStatusCode() == 401) {
				if (!validationErrorsList.isEmpty()) {
					throw new AuthNException(validationErrorsList);
				} else {
					throw new AuthManagerException(AuthErrorCode.RESPONSE_PARSE_ERROR.getErrorCode(),
							AuthErrorCode.RESPONSE_PARSE_ERROR.getErrorMessage(), ex);
				}
			}
			if (ex.getRawStatusCode() == 403) {
				if (!validationErrorsList.isEmpty()) {
					throw new AuthZException(validationErrorsList);
				} else {
					throw new AuthManagerException(AuthErrorCode.RESPONSE_PARSE_ERROR.getErrorCode(),
							AuthErrorCode.RESPONSE_PARSE_ERROR.getErrorMessage(), ex);
				}
			}
			if (!validationErrorsList.isEmpty()) {
				throw new AuthManagerServiceException(validationErrorsList);
			} else {
				throw new AuthManagerException(AuthErrorCode.CLIENT_ERROR.getErrorCode(), ex.getMessage(), ex);
			}
		}
	}

	@Override
	public OtpGenerateResponseDto generateOTPMultipleChannels(MosipUserDto mosipUserDto, OtpUser otpUser,
			String token) {
		try {
			List<ServiceError> validationErrorsList = null;
			OtpGenerateResponseDto otpGenerateResponseDto;
			OtpGenerateRequest otpGenerateRequestDto = new OtpGenerateRequest(mosipUserDto);
			final String url = mosipEnvironment.getGenerateOtpApi();

			RequestWrapper<OtpGenerateRequest> reqWrapper = new RequestWrapper<>();
			reqWrapper.setRequesttime(LocalDateTime.now());
			reqWrapper.setRequest(otpGenerateRequestDto);
			HttpHeaders headers = new HttpHeaders();
			headers.set(AuthConstant.COOKIE, AuthConstant.AUTH_HEADER + token);
			HttpEntity<RequestWrapper<OtpGenerateRequest>> request = new HttpEntity<>(reqWrapper, headers);
			ResponseEntity<String> response = restTemplate.postForEntity(url, request, String.class);
			validationErrorsList = ExceptionUtils.getServiceErrorList(response.getBody());
			if (!validationErrorsList.isEmpty()) {
				throw new AuthManagerServiceException(validationErrorsList);
			}
			ResponseWrapper<?> responseObject;
			try {
				responseObject = mapper.readValue(response.getBody(), ResponseWrapper.class);
				otpGenerateResponseDto = mapper.readValue(mapper.writeValueAsString(responseObject.getResponse()),
						OtpGenerateResponseDto.class);
			} catch (Exception e) {
				throw new AuthManagerException(String.valueOf(HttpStatus.UNAUTHORIZED.value()), e.getMessage(), e);
			}
			return otpGenerateResponseDto;
		} catch (HttpClientErrorException | HttpServerErrorException exp) {
			System.out.println(exp.getResponseBodyAsString());
			throw new AuthManagerException(String.valueOf(HttpStatus.UNAUTHORIZED.value()), exp.getMessage(), exp);
		}
	}

}
