/*
 * This file is part of ViaVersion - https://github.com/ViaVersion/ViaVersion
 * Copyright (C) 2016-2024 ViaVersion and contributors
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package com.viaversion.viaversion.api.minecraft.item.data;

import com.viaversion.viaversion.api.minecraft.Holder;
import com.viaversion.viaversion.api.type.Type;
import com.viaversion.viaversion.api.type.types.ArrayType;
import io.netty.buffer.ByteBuf;

public final class BannerPatternLayer {

    public static final Type<BannerPatternLayer> TYPE = new Type<BannerPatternLayer>(BannerPatternLayer.class) {
        @Override
        public BannerPatternLayer read(final ByteBuf buffer) throws Exception {
            final Holder<BannerPattern> pattern = BannerPattern.TYPE.read(buffer);
            final DyedColor color = DyedColor.TYPE.read(buffer);
            return new BannerPatternLayer(pattern, color);
        }

        @Override
        public void write(final ByteBuf buffer, final BannerPatternLayer value) throws Exception {
            BannerPattern.TYPE.write(buffer, value.pattern);
            DyedColor.TYPE.write(buffer, value.color);
        }
    };
    public static final Type<BannerPatternLayer[]> ARRAY_TYPE = new ArrayType<>(TYPE);

    private final Holder<BannerPattern> pattern;
    private final DyedColor color;

    public BannerPatternLayer(final Holder<BannerPattern> pattern, final DyedColor color) {
        this.pattern = pattern;
        this.color = color;
    }

    public Holder<BannerPattern> pattern() {
        return pattern;
    }

    public DyedColor color() {
        return color;
    }
}
