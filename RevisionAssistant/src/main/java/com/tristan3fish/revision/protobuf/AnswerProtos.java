// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: Answer.proto

package com.tristan3fish.revision.protobuf;

public final class AnswerProtos {
  private AnswerProtos() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  public interface AnswerProtoOrBuilder extends
      // @@protoc_insertion_point(interface_extends:revision.AnswerProto)
      com.google.protobuf.MessageOrBuilder {

    /**
     * <code>int32 answerId = 1;</code>
     */
    int getAnswerId();

    /**
     * <code>string timeCreated = 2;</code>
     */
    java.lang.String getTimeCreated();
    /**
     * <code>string timeCreated = 2;</code>
     */
    com.google.protobuf.ByteString
        getTimeCreatedBytes();

    /**
     * <code>int32 answerNumeric = 3;</code>
     */
    int getAnswerNumeric();

    /**
     * <code>bool correct = 4;</code>
     */
    boolean getCorrect();

    /**
     * <code>int64 hesitation_ms = 5;</code>
     */
    long getHesitationMs();

    /**
     * <code>int32 questionId = 6;</code>
     */
    int getQuestionId();
  }
  /**
   * Protobuf type {@code revision.AnswerProto}
   */
  public  static final class AnswerProto extends
      com.google.protobuf.GeneratedMessageV3 implements
      // @@protoc_insertion_point(message_implements:revision.AnswerProto)
      AnswerProtoOrBuilder {
    // Use AnswerProto.newBuilder() to construct.
    private AnswerProto(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
      super(builder);
    }
    private AnswerProto() {
      answerId_ = 0;
      timeCreated_ = "";
      answerNumeric_ = 0;
      correct_ = false;
      hesitationMs_ = 0L;
      questionId_ = 0;
    }

    @java.lang.Override
    public final com.google.protobuf.UnknownFieldSet
    getUnknownFields() {
      return com.google.protobuf.UnknownFieldSet.getDefaultInstance();
    }
    private AnswerProto(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      this();
      int mutable_bitField0_ = 0;
      try {
        boolean done = false;
        while (!done) {
          int tag = input.readTag();
          switch (tag) {
            case 0:
              done = true;
              break;
            default: {
              if (!input.skipField(tag)) {
                done = true;
              }
              break;
            }
            case 8: {

              answerId_ = input.readInt32();
              break;
            }
            case 18: {
              java.lang.String s = input.readStringRequireUtf8();

              timeCreated_ = s;
              break;
            }
            case 24: {

              answerNumeric_ = input.readInt32();
              break;
            }
            case 32: {

              correct_ = input.readBool();
              break;
            }
            case 40: {

              hesitationMs_ = input.readInt64();
              break;
            }
            case 48: {

              questionId_ = input.readInt32();
              break;
            }
          }
        }
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        throw e.setUnfinishedMessage(this);
      } catch (java.io.IOException e) {
        throw new com.google.protobuf.InvalidProtocolBufferException(
            e).setUnfinishedMessage(this);
      } finally {
        makeExtensionsImmutable();
      }
    }
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return com.tristan3fish.revision.protobuf.AnswerProtos.internal_static_revision_AnswerProto_descriptor;
    }

    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.tristan3fish.revision.protobuf.AnswerProtos.internal_static_revision_AnswerProto_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.tristan3fish.revision.protobuf.AnswerProtos.AnswerProto.class, com.tristan3fish.revision.protobuf.AnswerProtos.AnswerProto.Builder.class);
    }

    public static final int ANSWERID_FIELD_NUMBER = 1;
    private int answerId_;
    /**
     * <code>int32 answerId = 1;</code>
     */
    public int getAnswerId() {
      return answerId_;
    }

    public static final int TIMECREATED_FIELD_NUMBER = 2;
    private volatile java.lang.Object timeCreated_;
    /**
     * <code>string timeCreated = 2;</code>
     */
    public java.lang.String getTimeCreated() {
      java.lang.Object ref = timeCreated_;
      if (ref instanceof java.lang.String) {
        return (java.lang.String) ref;
      } else {
        com.google.protobuf.ByteString bs = 
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        timeCreated_ = s;
        return s;
      }
    }
    /**
     * <code>string timeCreated = 2;</code>
     */
    public com.google.protobuf.ByteString
        getTimeCreatedBytes() {
      java.lang.Object ref = timeCreated_;
      if (ref instanceof java.lang.String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        timeCreated_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }

    public static final int ANSWERNUMERIC_FIELD_NUMBER = 3;
    private int answerNumeric_;
    /**
     * <code>int32 answerNumeric = 3;</code>
     */
    public int getAnswerNumeric() {
      return answerNumeric_;
    }

    public static final int CORRECT_FIELD_NUMBER = 4;
    private boolean correct_;
    /**
     * <code>bool correct = 4;</code>
     */
    public boolean getCorrect() {
      return correct_;
    }

    public static final int HESITATION_MS_FIELD_NUMBER = 5;
    private long hesitationMs_;
    /**
     * <code>int64 hesitation_ms = 5;</code>
     */
    public long getHesitationMs() {
      return hesitationMs_;
    }

    public static final int QUESTIONID_FIELD_NUMBER = 6;
    private int questionId_;
    /**
     * <code>int32 questionId = 6;</code>
     */
    public int getQuestionId() {
      return questionId_;
    }

    private byte memoizedIsInitialized = -1;
    public final boolean isInitialized() {
      byte isInitialized = memoizedIsInitialized;
      if (isInitialized == 1) return true;
      if (isInitialized == 0) return false;

      memoizedIsInitialized = 1;
      return true;
    }

    public void writeTo(com.google.protobuf.CodedOutputStream output)
                        throws java.io.IOException {
      if (answerId_ != 0) {
        output.writeInt32(1, answerId_);
      }
      if (!getTimeCreatedBytes().isEmpty()) {
        com.google.protobuf.GeneratedMessageV3.writeString(output, 2, timeCreated_);
      }
      if (answerNumeric_ != 0) {
        output.writeInt32(3, answerNumeric_);
      }
      if (correct_ != false) {
        output.writeBool(4, correct_);
      }
      if (hesitationMs_ != 0L) {
        output.writeInt64(5, hesitationMs_);
      }
      if (questionId_ != 0) {
        output.writeInt32(6, questionId_);
      }
    }

    public int getSerializedSize() {
      int size = memoizedSize;
      if (size != -1) return size;

      size = 0;
      if (answerId_ != 0) {
        size += com.google.protobuf.CodedOutputStream
          .computeInt32Size(1, answerId_);
      }
      if (!getTimeCreatedBytes().isEmpty()) {
        size += com.google.protobuf.GeneratedMessageV3.computeStringSize(2, timeCreated_);
      }
      if (answerNumeric_ != 0) {
        size += com.google.protobuf.CodedOutputStream
          .computeInt32Size(3, answerNumeric_);
      }
      if (correct_ != false) {
        size += com.google.protobuf.CodedOutputStream
          .computeBoolSize(4, correct_);
      }
      if (hesitationMs_ != 0L) {
        size += com.google.protobuf.CodedOutputStream
          .computeInt64Size(5, hesitationMs_);
      }
      if (questionId_ != 0) {
        size += com.google.protobuf.CodedOutputStream
          .computeInt32Size(6, questionId_);
      }
      memoizedSize = size;
      return size;
    }

    private static final long serialVersionUID = 0L;
    @java.lang.Override
    public boolean equals(final java.lang.Object obj) {
      if (obj == this) {
       return true;
      }
      if (!(obj instanceof com.tristan3fish.revision.protobuf.AnswerProtos.AnswerProto)) {
        return super.equals(obj);
      }
      com.tristan3fish.revision.protobuf.AnswerProtos.AnswerProto other = (com.tristan3fish.revision.protobuf.AnswerProtos.AnswerProto) obj;

      boolean result = true;
      result = result && (getAnswerId()
          == other.getAnswerId());
      result = result && getTimeCreated()
          .equals(other.getTimeCreated());
      result = result && (getAnswerNumeric()
          == other.getAnswerNumeric());
      result = result && (getCorrect()
          == other.getCorrect());
      result = result && (getHesitationMs()
          == other.getHesitationMs());
      result = result && (getQuestionId()
          == other.getQuestionId());
      return result;
    }

    @java.lang.Override
    public int hashCode() {
      if (memoizedHashCode != 0) {
        return memoizedHashCode;
      }
      int hash = 41;
      hash = (19 * hash) + getDescriptor().hashCode();
      hash = (37 * hash) + ANSWERID_FIELD_NUMBER;
      hash = (53 * hash) + getAnswerId();
      hash = (37 * hash) + TIMECREATED_FIELD_NUMBER;
      hash = (53 * hash) + getTimeCreated().hashCode();
      hash = (37 * hash) + ANSWERNUMERIC_FIELD_NUMBER;
      hash = (53 * hash) + getAnswerNumeric();
      hash = (37 * hash) + CORRECT_FIELD_NUMBER;
      hash = (53 * hash) + com.google.protobuf.Internal.hashBoolean(
          getCorrect());
      hash = (37 * hash) + HESITATION_MS_FIELD_NUMBER;
      hash = (53 * hash) + com.google.protobuf.Internal.hashLong(
          getHesitationMs());
      hash = (37 * hash) + QUESTIONID_FIELD_NUMBER;
      hash = (53 * hash) + getQuestionId();
      hash = (29 * hash) + unknownFields.hashCode();
      memoizedHashCode = hash;
      return hash;
    }

    public static com.tristan3fish.revision.protobuf.AnswerProtos.AnswerProto parseFrom(
        com.google.protobuf.ByteString data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static com.tristan3fish.revision.protobuf.AnswerProtos.AnswerProto parseFrom(
        com.google.protobuf.ByteString data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static com.tristan3fish.revision.protobuf.AnswerProtos.AnswerProto parseFrom(byte[] data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static com.tristan3fish.revision.protobuf.AnswerProtos.AnswerProto parseFrom(
        byte[] data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static com.tristan3fish.revision.protobuf.AnswerProtos.AnswerProto parseFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input);
    }
    public static com.tristan3fish.revision.protobuf.AnswerProtos.AnswerProto parseFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input, extensionRegistry);
    }
    public static com.tristan3fish.revision.protobuf.AnswerProtos.AnswerProto parseDelimitedFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseDelimitedWithIOException(PARSER, input);
    }
    public static com.tristan3fish.revision.protobuf.AnswerProtos.AnswerProto parseDelimitedFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
    }
    public static com.tristan3fish.revision.protobuf.AnswerProtos.AnswerProto parseFrom(
        com.google.protobuf.CodedInputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input);
    }
    public static com.tristan3fish.revision.protobuf.AnswerProtos.AnswerProto parseFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input, extensionRegistry);
    }

    public Builder newBuilderForType() { return newBuilder(); }
    public static Builder newBuilder() {
      return DEFAULT_INSTANCE.toBuilder();
    }
    public static Builder newBuilder(com.tristan3fish.revision.protobuf.AnswerProtos.AnswerProto prototype) {
      return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
    }
    public Builder toBuilder() {
      return this == DEFAULT_INSTANCE
          ? new Builder() : new Builder().mergeFrom(this);
    }

    @java.lang.Override
    protected Builder newBuilderForType(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      Builder builder = new Builder(parent);
      return builder;
    }
    /**
     * Protobuf type {@code revision.AnswerProto}
     */
    public static final class Builder extends
        com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
        // @@protoc_insertion_point(builder_implements:revision.AnswerProto)
        com.tristan3fish.revision.protobuf.AnswerProtos.AnswerProtoOrBuilder {
      public static final com.google.protobuf.Descriptors.Descriptor
          getDescriptor() {
        return com.tristan3fish.revision.protobuf.AnswerProtos.internal_static_revision_AnswerProto_descriptor;
      }

      protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
          internalGetFieldAccessorTable() {
        return com.tristan3fish.revision.protobuf.AnswerProtos.internal_static_revision_AnswerProto_fieldAccessorTable
            .ensureFieldAccessorsInitialized(
                com.tristan3fish.revision.protobuf.AnswerProtos.AnswerProto.class, com.tristan3fish.revision.protobuf.AnswerProtos.AnswerProto.Builder.class);
      }

      // Construct using com.tristan3fish.revision.protobuf.AnswerProtos.AnswerProto.newBuilder()
      private Builder() {
        maybeForceBuilderInitialization();
      }

      private Builder(
          com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
        super(parent);
        maybeForceBuilderInitialization();
      }
      private void maybeForceBuilderInitialization() {
        if (com.google.protobuf.GeneratedMessageV3
                .alwaysUseFieldBuilders) {
        }
      }
      public Builder clear() {
        super.clear();
        answerId_ = 0;

        timeCreated_ = "";

        answerNumeric_ = 0;

        correct_ = false;

        hesitationMs_ = 0L;

        questionId_ = 0;

        return this;
      }

      public com.google.protobuf.Descriptors.Descriptor
          getDescriptorForType() {
        return com.tristan3fish.revision.protobuf.AnswerProtos.internal_static_revision_AnswerProto_descriptor;
      }

      public com.tristan3fish.revision.protobuf.AnswerProtos.AnswerProto getDefaultInstanceForType() {
        return com.tristan3fish.revision.protobuf.AnswerProtos.AnswerProto.getDefaultInstance();
      }

      public com.tristan3fish.revision.protobuf.AnswerProtos.AnswerProto build() {
        com.tristan3fish.revision.protobuf.AnswerProtos.AnswerProto result = buildPartial();
        if (!result.isInitialized()) {
          throw newUninitializedMessageException(result);
        }
        return result;
      }

      public com.tristan3fish.revision.protobuf.AnswerProtos.AnswerProto buildPartial() {
        com.tristan3fish.revision.protobuf.AnswerProtos.AnswerProto result = new com.tristan3fish.revision.protobuf.AnswerProtos.AnswerProto(this);
        result.answerId_ = answerId_;
        result.timeCreated_ = timeCreated_;
        result.answerNumeric_ = answerNumeric_;
        result.correct_ = correct_;
        result.hesitationMs_ = hesitationMs_;
        result.questionId_ = questionId_;
        onBuilt();
        return result;
      }

      public Builder clone() {
        return (Builder) super.clone();
      }
      public Builder setField(
          com.google.protobuf.Descriptors.FieldDescriptor field,
          Object value) {
        return (Builder) super.setField(field, value);
      }
      public Builder clearField(
          com.google.protobuf.Descriptors.FieldDescriptor field) {
        return (Builder) super.clearField(field);
      }
      public Builder clearOneof(
          com.google.protobuf.Descriptors.OneofDescriptor oneof) {
        return (Builder) super.clearOneof(oneof);
      }
      public Builder setRepeatedField(
          com.google.protobuf.Descriptors.FieldDescriptor field,
          int index, Object value) {
        return (Builder) super.setRepeatedField(field, index, value);
      }
      public Builder addRepeatedField(
          com.google.protobuf.Descriptors.FieldDescriptor field,
          Object value) {
        return (Builder) super.addRepeatedField(field, value);
      }
      public Builder mergeFrom(com.google.protobuf.Message other) {
        if (other instanceof com.tristan3fish.revision.protobuf.AnswerProtos.AnswerProto) {
          return mergeFrom((com.tristan3fish.revision.protobuf.AnswerProtos.AnswerProto)other);
        } else {
          super.mergeFrom(other);
          return this;
        }
      }

      public Builder mergeFrom(com.tristan3fish.revision.protobuf.AnswerProtos.AnswerProto other) {
        if (other == com.tristan3fish.revision.protobuf.AnswerProtos.AnswerProto.getDefaultInstance()) return this;
        if (other.getAnswerId() != 0) {
          setAnswerId(other.getAnswerId());
        }
        if (!other.getTimeCreated().isEmpty()) {
          timeCreated_ = other.timeCreated_;
          onChanged();
        }
        if (other.getAnswerNumeric() != 0) {
          setAnswerNumeric(other.getAnswerNumeric());
        }
        if (other.getCorrect() != false) {
          setCorrect(other.getCorrect());
        }
        if (other.getHesitationMs() != 0L) {
          setHesitationMs(other.getHesitationMs());
        }
        if (other.getQuestionId() != 0) {
          setQuestionId(other.getQuestionId());
        }
        onChanged();
        return this;
      }

      public final boolean isInitialized() {
        return true;
      }

      public Builder mergeFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws java.io.IOException {
        com.tristan3fish.revision.protobuf.AnswerProtos.AnswerProto parsedMessage = null;
        try {
          parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
        } catch (com.google.protobuf.InvalidProtocolBufferException e) {
          parsedMessage = (com.tristan3fish.revision.protobuf.AnswerProtos.AnswerProto) e.getUnfinishedMessage();
          throw e.unwrapIOException();
        } finally {
          if (parsedMessage != null) {
            mergeFrom(parsedMessage);
          }
        }
        return this;
      }

      private int answerId_ ;
      /**
       * <code>int32 answerId = 1;</code>
       */
      public int getAnswerId() {
        return answerId_;
      }
      /**
       * <code>int32 answerId = 1;</code>
       */
      public Builder setAnswerId(int value) {
        
        answerId_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>int32 answerId = 1;</code>
       */
      public Builder clearAnswerId() {
        
        answerId_ = 0;
        onChanged();
        return this;
      }

      private java.lang.Object timeCreated_ = "";
      /**
       * <code>string timeCreated = 2;</code>
       */
      public java.lang.String getTimeCreated() {
        java.lang.Object ref = timeCreated_;
        if (!(ref instanceof java.lang.String)) {
          com.google.protobuf.ByteString bs =
              (com.google.protobuf.ByteString) ref;
          java.lang.String s = bs.toStringUtf8();
          timeCreated_ = s;
          return s;
        } else {
          return (java.lang.String) ref;
        }
      }
      /**
       * <code>string timeCreated = 2;</code>
       */
      public com.google.protobuf.ByteString
          getTimeCreatedBytes() {
        java.lang.Object ref = timeCreated_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b = 
              com.google.protobuf.ByteString.copyFromUtf8(
                  (java.lang.String) ref);
          timeCreated_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <code>string timeCreated = 2;</code>
       */
      public Builder setTimeCreated(
          java.lang.String value) {
        if (value == null) {
    throw new NullPointerException();
  }
  
        timeCreated_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>string timeCreated = 2;</code>
       */
      public Builder clearTimeCreated() {
        
        timeCreated_ = getDefaultInstance().getTimeCreated();
        onChanged();
        return this;
      }
      /**
       * <code>string timeCreated = 2;</code>
       */
      public Builder setTimeCreatedBytes(
          com.google.protobuf.ByteString value) {
        if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
        
        timeCreated_ = value;
        onChanged();
        return this;
      }

      private int answerNumeric_ ;
      /**
       * <code>int32 answerNumeric = 3;</code>
       */
      public int getAnswerNumeric() {
        return answerNumeric_;
      }
      /**
       * <code>int32 answerNumeric = 3;</code>
       */
      public Builder setAnswerNumeric(int value) {
        
        answerNumeric_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>int32 answerNumeric = 3;</code>
       */
      public Builder clearAnswerNumeric() {
        
        answerNumeric_ = 0;
        onChanged();
        return this;
      }

      private boolean correct_ ;
      /**
       * <code>bool correct = 4;</code>
       */
      public boolean getCorrect() {
        return correct_;
      }
      /**
       * <code>bool correct = 4;</code>
       */
      public Builder setCorrect(boolean value) {
        
        correct_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>bool correct = 4;</code>
       */
      public Builder clearCorrect() {
        
        correct_ = false;
        onChanged();
        return this;
      }

      private long hesitationMs_ ;
      /**
       * <code>int64 hesitation_ms = 5;</code>
       */
      public long getHesitationMs() {
        return hesitationMs_;
      }
      /**
       * <code>int64 hesitation_ms = 5;</code>
       */
      public Builder setHesitationMs(long value) {
        
        hesitationMs_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>int64 hesitation_ms = 5;</code>
       */
      public Builder clearHesitationMs() {
        
        hesitationMs_ = 0L;
        onChanged();
        return this;
      }

      private int questionId_ ;
      /**
       * <code>int32 questionId = 6;</code>
       */
      public int getQuestionId() {
        return questionId_;
      }
      /**
       * <code>int32 questionId = 6;</code>
       */
      public Builder setQuestionId(int value) {
        
        questionId_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>int32 questionId = 6;</code>
       */
      public Builder clearQuestionId() {
        
        questionId_ = 0;
        onChanged();
        return this;
      }
      public final Builder setUnknownFields(
          final com.google.protobuf.UnknownFieldSet unknownFields) {
        return this;
      }

      public final Builder mergeUnknownFields(
          final com.google.protobuf.UnknownFieldSet unknownFields) {
        return this;
      }


      // @@protoc_insertion_point(builder_scope:revision.AnswerProto)
    }

    // @@protoc_insertion_point(class_scope:revision.AnswerProto)
    private static final com.tristan3fish.revision.protobuf.AnswerProtos.AnswerProto DEFAULT_INSTANCE;
    static {
      DEFAULT_INSTANCE = new com.tristan3fish.revision.protobuf.AnswerProtos.AnswerProto();
    }

    public static com.tristan3fish.revision.protobuf.AnswerProtos.AnswerProto getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }

    private static final com.google.protobuf.Parser<AnswerProto>
        PARSER = new com.google.protobuf.AbstractParser<AnswerProto>() {
      public AnswerProto parsePartialFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws com.google.protobuf.InvalidProtocolBufferException {
          return new AnswerProto(input, extensionRegistry);
      }
    };

    public static com.google.protobuf.Parser<AnswerProto> parser() {
      return PARSER;
    }

    @java.lang.Override
    public com.google.protobuf.Parser<AnswerProto> getParserForType() {
      return PARSER;
    }

    public com.tristan3fish.revision.protobuf.AnswerProtos.AnswerProto getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
    }

  }

  private static final com.google.protobuf.Descriptors.Descriptor
    internal_static_revision_AnswerProto_descriptor;
  private static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_revision_AnswerProto_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\014Answer.proto\022\010revision\"\207\001\n\013AnswerProto" +
      "\022\020\n\010answerId\030\001 \001(\005\022\023\n\013timeCreated\030\002 \001(\t\022" +
      "\025\n\ranswerNumeric\030\003 \001(\005\022\017\n\007correct\030\004 \001(\010\022" +
      "\025\n\rhesitation_ms\030\005 \001(\003\022\022\n\nquestionId\030\006 \001" +
      "(\005B2\n\"com.tristan3fish.revision.protobuf" +
      "B\014AnswerProtosb\006proto3"
    };
    com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner assigner =
        new com.google.protobuf.Descriptors.FileDescriptor.    InternalDescriptorAssigner() {
          public com.google.protobuf.ExtensionRegistry assignDescriptors(
              com.google.protobuf.Descriptors.FileDescriptor root) {
            descriptor = root;
            return null;
          }
        };
    com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        }, assigner);
    internal_static_revision_AnswerProto_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_revision_AnswerProto_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_revision_AnswerProto_descriptor,
        new java.lang.String[] { "AnswerId", "TimeCreated", "AnswerNumeric", "Correct", "HesitationMs", "QuestionId", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}
