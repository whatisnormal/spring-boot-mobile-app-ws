/*
 * The copyright of this file belongs to Feedzai. The file cannot be
 * reproduced in whole or in part, stored in a retrieval system,
 * transmitted in any form, or by any means electronic, mechanical,
 * photocopying, or otherwise, without the prior permission of the owner.
 *
 * (c) 2018 Feedzai, Strictly Confidential
 */

package com.whatisnormal.app.ws.service.impl;

import com.whatisnormal.app.ws.UserRepository;
import com.whatisnormal.app.ws.io.entity.UserEntity;
import com.whatisnormal.app.ws.service.UserService;
import com.whatisnormal.app.ws.shared.Utils;
import com.whatisnormal.app.ws.shared.dto.UserDto;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * FIXME
 *
 * @author José Fernandes (jose.fernandes@feedzai.com)
 * @since @@@feedzai.next.release@@@
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    Utils utils;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public UserDto createUser(final UserDto user) {

        if(userRepository.findByEmail(user.getEmail())!=null) throw  new RuntimeException("Record already exists");

        UserEntity userEntity = new UserEntity();
        BeanUtils.copyProperties(user, userEntity);

        String publicUserId = utils.generateUserId(30);

        userEntity.setEncryptedPassword(bCryptPasswordEncoder.encode(user.getPassword()) );
        userEntity.setUserId(publicUserId);

        UserEntity storedUserDetails =  userRepository.save(userEntity);

        UserDto returnValue = new UserDto();

        BeanUtils.copyProperties(storedUserDetails, returnValue);

        return returnValue;
    }

    @Override
    public UserDetails loadUserByUsername(final String s) throws UsernameNotFoundException {
        return null;
    }
}
