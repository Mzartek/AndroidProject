#ifndef ANDROIDPROJECT_TEXTURE2D_H
#define ANDROIDPROJECT_TEXTURE2D_H

#include "Texture.h"

namespace Engine
{
     class Texture2D : public Texture
     {
     public:
	  Texture2D(void);
	  ~Texture2D(void);
	  TextureType getType(void) const override;

	  void loadFromAsset(const GLchar *asset);
     };
}

#endif //ANDROIDPROJECT_TEXTURE2D_H
